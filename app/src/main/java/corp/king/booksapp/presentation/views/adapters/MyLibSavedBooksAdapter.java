package corp.king.booksapp.presentation.views.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import corp.king.booksapp.R;
import corp.king.booksapp.databinding.ItemSavedBookBinding;
import corp.king.booksapp.model.domain.Bookshelf;
import corp.king.booksapp.model.domain.ReadBook;
import corp.king.booksapp.model.domain.Volume;
import corp.king.booksapp.presentation.callbacks.BookSavingListener;

public class MyLibSavedBooksAdapter extends RecyclerView.Adapter<MyLibSavedBooksAdapter.MyLibViewHolder> {

    private ArrayList<ReadBook> mBooks;
    private BookSavingListener mListener;


    public MyLibSavedBooksAdapter(ArrayList<ReadBook> books, BookSavingListener listener) {
        this.mBooks = books;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public MyLibViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_saved_book, viewGroup, false);
        return new MyLibViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyLibViewHolder viewHolder, int i) {
        Volume book = mBooks.get(i).book;
        String imgLink = book.getVolumeInfo().getImageLinks().getMedium();
        String bookName = book.getVolumeInfo().getTitle();
        String bookAuthor = book.getVolumeInfo().getAuthors().toString();
        String publish = book.getVolumeInfo().getPublishedDate();
        viewHolder.bind(imgLink, bookName , bookAuthor, publish, mListener);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }


    class MyLibViewHolder extends RecyclerView.ViewHolder{

        ItemSavedBookBinding binding;

        public MyLibViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = DataBindingUtil.findBinding(itemView);

        }
        public void bind(String bookCover, String bookName, String bookAuthor, String bookPublish, BookSavingListener listener){
            //TODO: make placeholder
            Glide.with(itemView.getContext())
                    .load(bookCover)
                    .into(binding.bookImage);
            binding.bookName.setText(bookName);
            binding.bookAuthor.setText(bookAuthor);
            binding.bookPublish.setText(bookPublish);
            binding.setListener(listener);
        }
    }


}
