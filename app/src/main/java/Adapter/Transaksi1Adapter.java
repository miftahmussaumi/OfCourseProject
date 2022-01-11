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
import com.example.ofcourse.Model.ResponseTransaksi;
import com.example.ofcourse.R;

import java.util.List;

//Transaksi Sudah
public class Transaksi1Adapter extends RecyclerView.Adapter<Transaksi1Adapter.TransaksiHolder>{
    private Context context;
    private List<ResponseTransaksi> listdata;
    private String pathImage = "https://cdn.pixabay.com/photo/2021/02/12/07/03/red-icon-6007530_960_720.png";

    public Transaksi1Adapter(List<ResponseTransaksi> listdata, Context context) {
        this.context = context;
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public Transaksi1Adapter.TransaksiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pesanan_telah_item,parent,false);
        return new Transaksi1Adapter.TransaksiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransaksiHolder holder, int position) {
        holder.mapel.setText(listdata.get(position).getNamaMapel()+"");
        holder.guru.setText(listdata.get(position).getNamaGuru()+"");
        holder.tgl.setText(listdata.get(position).getTgl()+"");
        Glide.with(holder.itemView.getContext())
                .load(pathImage)
                .apply(new RequestOptions().fitCenter())
                .into(holder.foto);
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class TransaksiHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView mapel,guru,tgl;
        public TransaksiHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.f_foto_guru);
            mapel = itemView.findViewById(R.id.f_mapel);
            guru = itemView.findViewById(R.id.f_nama_guru);
            tgl = itemView.findViewById(R.id.f_tanggal);
        }
    }
}
