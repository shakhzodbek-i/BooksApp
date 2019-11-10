package corp.king.booksapp.presentation.views.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import corp.king.booksapp.R;
import corp.king.booksapp.model.domain.Volume;

public class MyLibReadBooksAdapter extends RecyclerView.Adapter<MyLibReadBooksAdapter.MyLibViewHolder> {

    private List<Volume> books;

    public MyLibReadBooksAdapter(List<Volume> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public MyLibViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_read_book, viewGroup, false);
        return new MyLibViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyLibViewHolder viewHolder, int i) {
        Volume book = books.get(i);
        Volume.ImageLinks imageLink = book.getVolumeInfo().getImageLinks();
        String title = book.getVolumeInfo().getTitle();
        List<String> author = book.getVolumeInfo().getAuthors();
        String publish = book.getVolumeInfo().getPublishedDate();
        int bookProgress = 0; //TODO: Reading position identifier

        viewHolder.bind(imageLink.getMedium(), title, author.toString(), publish, bookProgress);
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
        public void bind(String imageUrl, String bookName, String bookAuthor, String bookPublish, int progress){
            //TODO: Implement image parsing with Glide

            Glide.with(itemView.getContext())
                    .load(imageUrl)
                    .centerCrop()
                    .into(bookCover);

            this.bookName.setText(bookName);
            this.bookAuthor.setText(bookAuthor);
            this.bookPublish.setText(bookPublish);
            this.progressPercent.setText(String.valueOf(progress)+'%');
            this.readingProgress.setProgress(progress);
        }
    }


}
