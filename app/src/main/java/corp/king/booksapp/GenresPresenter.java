package corp.king.booksapp;

import android.view.View;

public class GenresPresenter implements OnGenreClickListener {
    private GenresView mView;

    GenresPresenter(GenresView mView) {
        this.mView = mView;
    }

    public void loadGenres(){
        int[] mGenresImgIds = generateGenres();
        mView.showGenres(mGenresImgIds);
    }

    private int[] generateGenres(){
        return new int[] {
                R.drawable.sciencehdpi,
                R.drawable.classichdpi,
                R.drawable.comicshdpi,
                R.drawable.historyhdpi,
                R.drawable.dramahdpi,
                R.drawable.horrorhdpi,
                R.drawable.crimehdpi,
                R.drawable.fantasyhdpi,
                R.drawable.mysteryhdpi,
                R.drawable.politicshdpi,
                R.drawable.psycologyhdpi,
                R.drawable.romancehdpi
        };
    }

    @Override
    public void onGenreClick(View view) {
        mView.showMsg("It works!");
    }
}
