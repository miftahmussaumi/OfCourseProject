package Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ofcourse.DetailGuru;
import com.example.ofcourse.ListGuru;
import com.example.ofcourse.Model.ResponseGuru;
import com.example.ofcourse.R;

import java.util.List;

public class GuruAdapter extends RecyclerView.Adapter<GuruAdapter.MapelHolder> {
    List<ResponseGuru> listdata;
    private Context context;
    private String pathImage = "https://cdn.pixabay.com/photo/2016/05/31/13/22/maths-1426891_1280.png";

    public GuruAdapter(List<ResponseGuru> listdata, Context context){
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public GuruAdapter.MapelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_listmapel_item,parent,false);
        final GuruAdapter.MapelHolder viewHolder = new GuruAdapter.MapelHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(parent.getContext(), DetailGuru.class);
                ResponseGuru result = new ResponseGuru();
                result.setNamaGuru(listdata.get(viewHolder.getAdapterPosition()).getNamaGuru());
                result.setNamaMapel(listdata.get(viewHolder.getAdapterPosition()).getNamaMapel());
                result.setPendidikan(listdata.get(viewHolder.getAdapterPosition()).getPendidikan());
                result.setKetGuru(listdata.get(viewHolder.getAdapterPosition()).getKetGuru());
                result.setUpah(listdata.get(viewHolder.getAdapterPosition()).getUpah());
                i.putExtra(DetailGuru.ITEM_EXTRA, result);
                parent.getContext().startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MapelHolder holder, @SuppressLint("RecyclerView") int position) {
        ResponseGuru responseGuru =listdata.get(position);
        holder.guru.setText(responseGuru.getNamaGuru()+"");
        holder.mapel.setText(responseGuru.getNamaMapel()+"");
        holder.lokasi.setText(responseGuru.getAlamat()+"");
        Glide.with(holder.itemView.getContext())
                .load(pathImage)
                .apply(new RequestOptions().fitCenter())
                .into(holder.photo);
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class MapelHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView guru;
        TextView mapel;
        TextView lokasi;
        TextView score;
        CardView detail;
        public MapelHolder(@NonNull View itemView) {
            super(itemView);
            photo   = itemView.findViewById(R.id.lm_photo);
            guru    = itemView.findViewById(R.id.lm_guru);
            mapel   = itemView.findViewById(R.id.lm_mapel);
            lokasi  = itemView.findViewById(R.id.lm_lokasi);
            score   = itemView.findViewById(R.id.lm_score);
            detail  = itemView.findViewById(R.id.listguru);
        }
    }
}
