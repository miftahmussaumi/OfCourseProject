package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ofcourse.Model.ResponseReview;
import com.example.ofcourse.R;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {
    List<ResponseReview> data;
    Context context;
    private String pathImage = "https://cdn.pixabay.com/photo/2016/05/31/13/22/maths-1426891_1280.png";

    public ReviewAdapter(List<ResponseReview> data, Context context){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_item_review,parent,false);
        return new ReviewAdapter.ReviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        holder.user.setText(data.get(position).getName()+"");
        holder.review.setText(data.get(position).getReview()+"");
        Glide.with(holder.itemView.getContext())
                .load(pathImage)
                .apply(new RequestOptions().fitCenter())
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ReviewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView user, review;
        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
            photo   = itemView.findViewById(R.id.r_foto);
            user    = itemView.findViewById(R.id.r_nama_user);
            review   = itemView.findViewById(R.id.r_review);
        }
    }
}
