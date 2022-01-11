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
import com.example.ofcourse.R;
import com.example.ofcourse.Response.Response;
import com.example.ofcourse.Response.Result;
import com.example.ofcourse.responsemodel;
import com.example.ofcourse.responsemodelsearch;

import org.w3c.dom.Text;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private Context context;
    private List<responsemodelsearch> resultList;
    private String pathImage = "https://cdn.pixabay.com/photo/2021/02/12/07/03/red-icon-6007530_960_720.png";

    public SearchAdapter(Context context, List<responsemodelsearch> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_search, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final responsemodelsearch responsemodelsearch = resultList.get(position);
        String  s_guru = responsemodelsearch.getNama_guru();
        String  s_mapel = responsemodelsearch.getNama_mapel();
        String  s_lokasi = responsemodelsearch.getAlamat();


        holder.s_guru.setText(s_guru);
        holder.s_mapel.setText(s_mapel);
        holder.s_lokasi.setText(s_lokasi);

        Glide.with(holder.itemView.getContext())
                .load(pathImage)
                .apply(new RequestOptions().fitCenter())
                .into(holder.s_photo);

    }


    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView s_guru, s_mapel, s_lokasi;
        ImageView s_photo;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            s_guru = itemView.findViewById(R.id.s_guru);
            s_mapel = itemView.findViewById(R.id.s_mapel);
            s_lokasi = itemView.findViewById(R.id.s_lokasi);
            s_photo = itemView.findViewById(R.id.s_photo);

        }
    }
}
