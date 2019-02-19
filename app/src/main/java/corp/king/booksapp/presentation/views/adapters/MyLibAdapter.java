package corp.king.booksapp.presentation.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import corp.king.booksapp.R;
import corp.king.booksapp.data.Book;
import corp.king.booksapp.data.ReadBook;

public class MyLibAdapter extends RecyclerView.Adapter<MyLibAdapter.MyLibViewHolder> {

    private ArrayList<ReadBook> books;

    public MyLibAdapter(ArrayList<ReadBook> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public MyLibViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mylib, viewGroup, false);
        return new MyLibViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyLibViewHolder viewHolder, int i) {
        Book book = books.get(i).book;
        int bookProgress = books.get(i).progress;
        viewHolder.bind(book.coverURL, book.name, book.author, book.publish, bookProgress);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }


    class MyLibViewHolder extends RecyclerView.ViewHolder{

        private ImageView bookCover;
        private TextView bookName;
        private TextView bookAuthor;
        private TextView bookPublish;
        private TextView progressPercent;
        private ProgressBar readingProgress;

        public MyLibViewHolder(@NonNull View itemView) {
            super(itemView);

            bookCover = itemView.findViewById(R.id.book_image);
            bookName = itemView.findViewById(R.id.book_name);
            bookAuthor = itemView.findViewById(R.id.book_author);
            bookPublish = itemView.findViewById(R.id.book_publish);
            progressPercent = itemView.findViewById(R.id.progressBar);
            readingProgress = itemView.findViewById(R.id.progress_percent);

        }
        public void bind(String bookCover, String bookName, String bookAuthor, String bookPublish, int progress){
            //TODO: Implement image parsing with Picasso

            this.bookName.setText(bookName);
            this.bookAuthor.setText(bookAuthor);
            this.bookPublish.setText(bookPublish);
            this.progressPercent.setText(String.valueOf(progress)+'%');
            this.readingProgress.setProgress(progress);
        }
    }


}
