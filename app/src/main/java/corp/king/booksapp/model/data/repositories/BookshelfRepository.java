package corp.king.booksapp.model.data.repositories;

import java.util.List;

import corp.king.booksapp.model.domain.Bookshelf;
import corp.king.booksapp.model.domain.Volume;

public interface BookshelfRepository {

    List<Bookshelf> getBookshelfList(String userId);

    Bookshelf getBookshelf(String userId, String shelfId);

    List<Volume> getReadingBooks(String userId);

    List<Volume> getSavedBooks(String userId);
}
