package corp.king.booksapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {
    private int[] mImageIds;
    private GenreCallback mListener;
    GenreAdapter(int[] imagesIds, GenreCallback listener) {
        this.mImageIds = imagesIds;
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        if (mImageIds == null) {
            return 0;
        }
        return mImageIds.length;
    }

    @NonNull
    @Override
    public GenreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_genres, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mImageIds[position]);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
       private ImageView imgCheckedView;

        ViewHolder(View itemView) {
            super(itemView);
            imgCheckedView = itemView.findViewById(R.id.genre_pic);
        }

        void bind(int picId){
            imgCheckedView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   int adapterPosition = getAdapterPosition();
                    mListener.onGenreClick(v, adapterPosition);
                }
            });

            imgCheckedView.setImageResource(picId);
        }
    }
}
