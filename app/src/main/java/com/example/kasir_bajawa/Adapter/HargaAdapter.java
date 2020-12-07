package com.example.kasir_bajawa.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kasir_bajawa.Model.AtasNamaModel;
import com.example.kasir_bajawa.Model.HargaModel;
import com.example.kasir_bajawa.R;

import java.util.ArrayList;

public class HargaAdapter extends RecyclerView.Adapter<HargaAdapter.HomeViewHolder>{

    private ArrayList<HargaModel> dataList;
    View viewku;

    public HargaAdapter(ArrayList<HargaModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        viewku = layoutInflater.inflate(R.layout.list_item_harga, parent, false);
        return new HomeViewHolder(viewku);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
            holder.txtharga.setText(dataList.get(position).getHargaC());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{
        private TextView txtharga;

        HomeViewHolder(View itemView) {
            super(itemView);
            txtharga = itemView.findViewById(R.id.txtHargaC);

        }
    }

}
