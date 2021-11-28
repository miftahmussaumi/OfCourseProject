package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ofcourse.R;

import java.util.ArrayList;

import Model.Pencarian;


public class PencarianAdapter extends RecyclerView.Adapter<PencarianAdapter.PencarianHolder>{
    private ArrayList<Pencarian> listdata;
    public PencarianAdapter(ArrayList<Pencarian> listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public PencarianHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view                           = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pencarian_item,parent,false);
        PencarianHolder holder     = new PencarianHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PencarianHolder holder, int position) {
        final Pencarian getData = listdata.get(position);
        String photo    = getData.getP_photo();
        String guru     = getData.getP_guru();
        String mapel    = getData.getP_mapel();
        String lokasi   = getData.getP_lokasi();
        String score    = getData.getP_score();

        holder.guru.setText(guru);
        holder.mapel.setText(mapel);
        holder.lokasi.setText(lokasi);
        holder.score.setText(score);
        if(photo.equals("profil")){
            holder.photo.setImageResource(R.drawable.profil1);
        } else if(photo.equals("profil1")){
            holder.photo.setImageResource(R.drawable.profil2);
        } else if(photo.equals("profil2")){
            holder.photo.setImageResource(R.drawable.profil3);
        } else if(photo.equals("profil3")){
            holder.photo.setImageResource(R.drawable.profil4);
        }
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class PencarianHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView guru;
        TextView mapel;
        TextView lokasi;
        TextView score;
        public PencarianHolder(@NonNull View itemView) {
            super(itemView);
            photo   = itemView.findViewById(R.id.p_photo);
            guru    = itemView.findViewById(R.id.p_guru);
            mapel   = itemView.findViewById(R.id.p_mapel);
            lokasi  = itemView.findViewById(R.id.p_lokasi);
            score   = itemView.findViewById(R.id.p_score);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Pencarian Pencarian = listdata.get(getAdapterPosition());
                    clickObject.onClick(Pencarian);
                }
            });
        }
    }

    // Click Listener
    public interface OnPencarianViewHolderClick{
        void onClick(Pencarian Pencarian);
    }

    OnPencarianViewHolderClick clickObject;

    public void setClickObject(OnPencarianViewHolderClick clickObject) {
        this.clickObject = clickObject;
    }

    public void setListdata(ArrayList<Pencarian> listdata) {
        this.listdata = listdata;
    }
}
