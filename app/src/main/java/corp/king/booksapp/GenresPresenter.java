package corp.king.booksapp;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class GenresPresenter implements GenreCallback{
    private GenresView mView;
    private ArrayList<Integer> selectedGenrePosition = new ArrayList<>();

    GenresPresenter(GenresView mView) {
        this.mView = mView;
    }

    void loadGenres(){
        int[] mGenresImgIds = generateGenres();
        mView.showGenres(mGenresImgIds);
    }

    private int[] generateGenres(){
        return new int[] {
                R.drawable.science,
                R.drawable.classic,
                R.drawable.comics,
                R.drawable.history,
                R.drawable.drama,
                R.drawable.horror,
                R.drawable.crime,
                R.drawable.fantasy,
                R.drawable.mystery,
                R.drawable.politics,
                R.drawable.psychology,
                R.drawable.romance
        };
    }

    @Override
    public void onGenreClick(View view, Integer adapterPosition) {
        ImageView imgCheckedView = view.findViewById(R.id.genre_pic);

        if (imgCheckedView.getImageAlpha() != 50) {
            if (selectedGenrePosition.size() < 5) {
                selectedGenrePosition.add(adapterPosition);
                imgCheckedView.setImageAlpha(50);
                if (selectedGenrePosition.size() == 5) {
                    mView.showNextBtn(View.VISIBLE);
                }
            }
        } else {
            imgCheckedView.setSelected(false);
            selectedGenrePosition.remove(adapterPosition);
            imgCheckedView.setImageAlpha(255);
            mView.showNextBtn(View.INVISIBLE);
        }
    }

    @Override
    public void onDoneClick(View view) {

    }
}
