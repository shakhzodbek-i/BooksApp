package corp.king.booksapp.presentation.presenters.interfaces;

import android.support.design.widget.TabLayout;

import corp.king.booksapp.presentation.listeners.BookSavingListener;

public interface MyLibPresenter extends TabLayout.BaseOnTabSelectedListener, BookSavingListener {
    void loadBooks(int tabId);

    void openBook(String volumeId);
}
