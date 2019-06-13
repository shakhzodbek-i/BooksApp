package corp.king.booksapp.presentation.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import corp.king.booksapp.R;
import corp.king.booksapp.model.data.repositories.BookshelfRepository;
import corp.king.booksapp.model.domain.Volume;
import corp.king.booksapp.presentation.presenters.MyLibPresenterImpl;
import corp.king.booksapp.presentation.presenters.interfaces.MyLibPresenter;
import corp.king.booksapp.presentation.views.adapters.MyLibReadBooksAdapter;
import corp.king.booksapp.presentation.views.adapters.MyLibSavedBooksAdapter;
import corp.king.booksapp.presentation.views.interfaces.IMyLibView;
import corp.king.booksapp.utility.Constants;
import corp.king.booksapp.utility.SharedPreferencesHelper;

public class MyLibActivity extends AppCompatActivity implements IMyLibView {

    private TabLayout mTabLayout;

    private RecyclerView mBookList;

    private MyLibPresenter mPresenter;

    private String mUserId;

    private MyLibReadBooksAdapter mReadAdapter;

    private MyLibSavedBooksAdapter mSavedAdapter;

    @Inject
    private BookshelfRepository mBookshelfRepository;

    @Inject
    private SharedPreferencesHelper mSharedPreference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylib);

        mUserId = mSharedPreference.getString(Constants.USER_ID);

        mPresenter = new MyLibPresenterImpl(this, mBookshelfRepository, mUserId);

        mTabLayout = findViewById(R.id.tab);

        mBookList = findViewById(R.id.book_list);

        mBookList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mTabLayout.addOnTabSelectedListener(mPresenter);

    }


    @Override
    public void showMyReadingBooks(List<Volume> books) {

        mReadAdapter = new MyLibReadBooksAdapter(books);

        mBookList.setAdapter(mReadAdapter);
    }

    @Override
    public void showMySavedBooks(List<Volume> books) {

        mSavedAdapter = new MyLibSavedBooksAdapter(books, mPresenter);

        mBookList.setAdapter(mSavedAdapter);
    }
}
