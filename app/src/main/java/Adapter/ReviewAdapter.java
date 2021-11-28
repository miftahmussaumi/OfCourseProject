package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ofcourse.R;
import Model.Review;


import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    //VIEW HOLDER
    public class ReviewViewHolder extends RecyclerView.ViewHolder {
//        ImageView fotoReview;
        TextView textUser, textReview;
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
//            fotoReview = itemView.findViewById(R.id.fotoReview);
            textUser = itemView.findViewById(R.id.textUser);
            textReview = itemView.findViewById(R.id.textReview);
        }
    }


    //UNTUK DATA YANG AKAN DITAMPILKAN
    ArrayList<Review> listReview =  new ArrayList<>();
    public void setListReview(ArrayList<Review> listReview) {
        this.listReview = listReview;
        notifyDataSetChanged();
    }

    //METHOD ADAPTER
    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        ReviewViewHolder viewHolder = new ReviewViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder viewHolder, int position) {
        Review review = listReview.get(position);
//        viewHolder.fotoReview.setImageDrawable(review.fotoProfil.toString());
        viewHolder.textUser.setText(review.namaUser);
        viewHolder.textReview.setText(review.isiReview);
    }

    @Override
    public int getItemCount() {

        return listReview.size();
    }


}
