package corp.king.booksapp.models;

import java.util.List;

public class BookshelvesList {
    String kind;
    List<Bookshelf> bookshelves;

    public String getKind() {
        return kind;
    }

    public List<Bookshelf> getBookshelves() {
        return bookshelves;
    }
}
