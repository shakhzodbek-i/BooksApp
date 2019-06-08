package corp.king.booksapp;

public class GenresPresenter {
    private GenresView mView;

    GenresPresenter(GenresView mView) {
        this.mView = mView;
        loadGenres();
    }

    private void loadGenres(){
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
}
