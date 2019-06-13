package corp.king.booksapp.presentation.views.interfaces;

import java.util.List;

import corp.king.booksapp.model.domain.Volume;

public interface IMyLibView {
    void showMyReadingBooks(List<Volume> books);

    void showMySavedBooks(List<Volume> books);
}
