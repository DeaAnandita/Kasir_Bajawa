package com.example.kasir_bajawa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{

    private ArrayList<HomeModel> dataList;
    View viewku;

    public HomeAdapter(ArrayList<HomeModel> dataList) {
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        viewku = layoutInflater.inflate(R.layout.itemview, parent, false);
        return new HomeViewHolder(viewku);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.txtnama.setText(dataList.get(position).getNama());
        holder.txtTime.setText(dataList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    class HomeViewHolder extends RecyclerView.ViewHolder{
        TextView txtNext, txtnama, txtTime;
        CardView cardku;

        HomeViewHolder(View itemView) {
            super(itemView);
            cardku = itemView.findViewById(R.id.cardku_D);
            txtNext = itemView.findViewById(R.id.txtNext);
            txtnama = itemView.findViewById(R.id.txtAtasNamaa);
            txtTime = itemView.findViewById(R.id.txtTime);
        }
    }

}
