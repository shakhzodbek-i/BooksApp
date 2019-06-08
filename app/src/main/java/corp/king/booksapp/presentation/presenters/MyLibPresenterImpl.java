package corp.king.booksapp.presentation.presenters;

import android.support.design.widget.TabLayout;
import android.view.View;

import java.util.List;

import corp.king.booksapp.model.data.repositories.BookshelfRepository;
import corp.king.booksapp.model.domain.Volume;
import corp.king.booksapp.presentation.presenters.interfaces.MyLibPresenter;
import corp.king.booksapp.presentation.views.interfaces.IMyLibView;

public class MyLibPresenterImpl implements MyLibPresenter {
    private IMyLibView mView;
    private BookshelfRepository mRepository;
    private List<Volume> mListOfBooks;
    private String mUserId;

    public MyLibPresenterImpl(IMyLibView view, BookshelfRepository repository, String userId) {
        this.mView = view;
        this.mRepository = repository;
        this.mUserId = userId;
    }

    @Override
    public void loadBooks(int tabId) {
        if (tabId == 0) {
            mListOfBooks = mRepository.getReadingBooks(mUserId);
            mView.showMyReadingBooks(mListOfBooks);

        } else if (tabId == 1) {
            mListOfBooks = mRepository.getSavedBooks(mUserId);
            mView.showMySavedBooks(mListOfBooks);
        }

    }

    @Override
    public void openBook(String volumeId) {
        //TODO: Open book function
    }

    @Override
    public void saveBook(View view) {

    }

    @Override
    public void removeBook(View view) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab.getText() == "Read")
            loadBooks(0);
        else
            loadBooks(1);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
