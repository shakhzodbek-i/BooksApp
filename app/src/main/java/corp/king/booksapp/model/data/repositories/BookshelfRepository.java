package corp.king.booksapp.model.data.repositories;

import java.util.List;

import corp.king.booksapp.model.domain.Bookshelf;

public interface BookshelfRepository {

    List<Bookshelf> getBookshelfList(String userId);

    Bookshelf getBookshelf(String userId, String shelfId);

}
