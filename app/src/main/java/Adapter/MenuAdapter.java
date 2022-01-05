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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ofcourse.ListGuru;
import com.example.ofcourse.R;
import com.example.ofcourse.Model.ResponseMenu;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.AdapterHolder> {
    List<ResponseMenu> list;
    Context context;
    private String pathImage = "https://cdn.pixabay.com/photo/2016/05/31/13/22/maths-1426891_1280.png";

    public MenuAdapter(List<ResponseMenu> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuAdapter.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_menu_item,parent,false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mapel.setText(list.get(position).getNamaMapel()+"");
        Glide.with(holder.itemView.getContext())
                .load(pathImage)
                .apply(new RequestOptions().fitCenter())
                .into(holder.gambar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListGuru.class);
                intent.putExtra("post", list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView mapel;
        ImageView gambar;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            mapel = itemView.findViewById(R.id.m_mapel);
            gambar = itemView.findViewById(R.id.m_gambar);
        }
    }
}