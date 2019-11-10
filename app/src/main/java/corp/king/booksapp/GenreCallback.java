package corp.king.booksapp;

import android.view.View;

public interface GenreCallback {
    void onGenreClick(View view, Integer adapterPosition);
    void onDoneClick(View view);
}
