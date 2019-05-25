package corp.king.booksapp.model.data.repositories;

import java.util.List;

import corp.king.booksapp.model.data.api.BookshelfApi;
import corp.king.booksapp.model.domain.Bookshelf;
import corp.king.booksapp.model.domain.BookshelvesList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookshelfRepositoryImpl implements BookshelfRepository {
    private BookshelvesList mBookshelvesList;
    private BookshelfApi mBookshelfRepo;
    private Bookshelf mBookshelf;

    public BookshelfRepositoryImpl(BookshelfApi bookshelfApi) {
        mBookshelfRepo = bookshelfApi;
    }

    public List<Bookshelf> getBookshelfList(String userId) {
        mBookshelfRepo.getBookshelfList(userId).enqueue(new Callback<BookshelvesList>() {
            @Override
            public void onResponse(Call<BookshelvesList> call, Response<BookshelvesList> response) {
                mBookshelvesList = response.body();
            }

            @Override
            public void onFailure(Call<BookshelvesList> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return mBookshelvesList.getBookshelves();
    }

    public Bookshelf getBookshelf(String userId, String shelfId){
        mBookshelfRepo.getBookshelf(userId, shelfId).enqueue(new Callback<Bookshelf>() {
            @Override
            public void onResponse(Call<Bookshelf> call, Response<Bookshelf> response) {
                mBookshelf = response.body();
            }

            @Override
            public void onFailure(Call<Bookshelf> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return mBookshelf;
    }
}
