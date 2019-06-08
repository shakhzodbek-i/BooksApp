package corp.king.booksapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class GenresActivity extends AppCompatActivity implements GenresView{

    private RecyclerView mRecyclerView;
    protected GenresPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres);

        mRecyclerView = findViewById(R.id.rw);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mPresenter = new GenresPresenter(this);
    }


    @Override
    public void showGenres(int[] genresImgIds) {
        GenreAdapter mAdapter = new GenreAdapter(genresImgIds);
        mRecyclerView.setAdapter(mAdapter);
    }
}
