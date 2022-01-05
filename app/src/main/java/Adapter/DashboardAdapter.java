
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

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardHolder> {
    private ArrayList<Dashboard> listdata;
    public DashboardAdapter(ArrayList<Dashboard> listdata){
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public DashboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view               = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dashboard_item,parent,false);
        DashboardHolder holder  = new DashboardHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardHolder holder, int position) {
        final Dashboard getData = listdata.get(position);
        String titlemenu = getData.getMapel();
        String logomenu = getData.getPict();

        holder.titleMenu.setText(titlemenu);
        if(logomenu.equals("pictmat")){
            holder.imgMenu.setImageResource(R.drawable.pictmat);
        } else if(logomenu.equals("pictkim")){
            holder.imgMenu.setImageResource(R.drawable.pictkim);
        } else if(logomenu.equals("pictfis")){
            holder.imgMenu.setImageResource(R.drawable.pictfis);
        } else if(logomenu.equals("picteng")){
            holder.imgMenu.setImageResource(R.drawable.picteng);
        } else if(logomenu.equals("pictbio")){
            holder.imgMenu.setImageResource(R.drawable.pictbio);
        } else if(logomenu.equals("picttpa")){
            holder.imgMenu.setImageResource(R.drawable.picttpa);
        } else if(logomenu.equals("pictbiola")){
            holder.imgMenu.setImageResource(R.drawable.pictbiola);
        } else if(logomenu.equals("pictgitar")){
            holder.imgMenu.setImageResource(R.drawable.pictgitar);
        } else if(logomenu.equals("pictpiano")){
            holder.imgMenu.setImageResource(R.drawable.pictpiano);
        }
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class DashboardHolder extends RecyclerView.ViewHolder {
        TextView titleMenu;
        ImageView imgMenu;

        public DashboardHolder(@NonNull View itemView) {
            super(itemView);
            titleMenu   = itemView.findViewById(R.id.mapel);
            imgMenu     = itemView.findViewById(R.id.pict);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Dashboard dashboard = listdata.get(getAdapterPosition());
                    clickObject.onClick(dashboard);
                }
            });
        }
    }

    // Click Listener
    public interface OnDashViewHolderClick{
        void onClick(Dashboard dashboard);
    }

    OnDashViewHolderClick clickObject;

    public void setClickObject(OnDashViewHolderClick clickObject) {
        this.clickObject = clickObject;
    }

    public void setListdata(ArrayList<Dashboard> listdata) {
        this.listdata = listdata;
    }
}