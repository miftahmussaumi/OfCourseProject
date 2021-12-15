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
import com.example.ofcourse.responsemodel;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.AdapterHolder> {

    private Context context;
    private List<responsemodel> datalist;
    private String pathImage = "https://cdn.pixabay.com/photo/2016/05/31/13/22/maths-1426891_1280.png";
    public MenuAdapter(Context context, List<responsemodel> datalist){
        this.context = context;
        this.datalist= datalist;
    }

    @NonNull
    @Override
    public MenuAdapter.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_menu_item,parent,false);
        AdapterHolder holder = new AdapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.AdapterHolder holder, int position) {

        final responsemodel responsemodel = datalist.get(position);
        String  m_mapel = responsemodel.getNama_mapel();

        holder.m_mapel.setText(m_mapel);
        Glide.with(holder.itemView.getContext())
                .load(pathImage)
                .apply(new RequestOptions().fitCenter())
                .into(holder.m_gambar);

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public interface OnDashViewHolderClick {
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView m_mapel;
        ImageView m_gambar;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);

            m_mapel = itemView.findViewById(R.id.m_mapel);
            m_gambar = itemView.findViewById(R.id.m_gambar);

        }
    }
}