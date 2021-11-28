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

import Model.Dashboard;
import Model.Mapel;
import de.hdodenhof.circleimageview.CircleImageView;

public class MapelAdapter extends RecyclerView.Adapter<MapelAdapter.MapelHolder> {
    private ArrayList<Mapel> listdata;
    public MapelAdapter(ArrayList<Mapel> listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public MapelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view                           = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_listmapel_item,parent,false);
        MapelAdapter.MapelHolder holder     = new MapelAdapter.MapelHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MapelHolder holder, int position) {
        final Mapel getData = listdata.get(position);
        String photo    = getData.getLm_photo();
        String guru     = getData.getLm_guru();
        String mapel    = getData.getLm_mapel();
        String lokasi   = getData.getLm_lokasi();
        String score    = getData.getLm_score();

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

    public class MapelHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView guru;
        TextView mapel;
        TextView lokasi;
        TextView score;
        public MapelHolder(@NonNull View itemView) {
            super(itemView);
            photo   = itemView.findViewById(R.id.lm_photo);
            guru    = itemView.findViewById(R.id.lm_guru);
            mapel   = itemView.findViewById(R.id.lm_mapel);
            lokasi  = itemView.findViewById(R.id.lm_lokasi);
            score   = itemView.findViewById(R.id.lm_score);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Mapel mapel = listdata.get(getAdapterPosition());
                    clickObject.onClick(mapel);
                }
            });
        }
    }

    // Click Listener
    public interface OnMapelViewHolderClick{
        void onClick(Mapel mapel);
    }

    MapelAdapter.OnMapelViewHolderClick clickObject;

    public void setClickObject(MapelAdapter.OnMapelViewHolderClick clickObject) {
        this.clickObject = clickObject;
    }

    public void setListdata(ArrayList<Mapel> listdata) {
        this.listdata = listdata;
    }
}
