package corp.king.booksapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

public class GenresActivity extends AppCompatActivity implements GenresView{

    private RecyclerView mRecyclerView;
    private GenresPresenter mPresenter;
    private Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        mRecyclerView = findViewById(R.id.rw);
        mNextButton = findViewById(R.id.next_button);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mPresenter = new GenresPresenter(this);
        mPresenter.loadGenres();
    }

    @Override
    public void showGenres(int[] genresImgIds) {
        GenreAdapter mAdapter = new GenreAdapter(genresImgIds, mPresenter);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showNextBtn(int nextBtnVisibility) {
        mNextButton.setVisibility(nextBtnVisibility);
    }
}
