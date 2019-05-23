package corp.king.booksapp.data.repositories;

import java.util.List;

import corp.king.booksapp.models.Bookshelf;

public interface BookshelfRepository {

    List<Bookshelf> getBookshelfList(String userId);

    Bookshelf getBookshelf(String userId, String shelfId);

}
