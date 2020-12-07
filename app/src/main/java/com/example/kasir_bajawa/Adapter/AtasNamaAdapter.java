package com.example.kasir_bajawa.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kasir_bajawa.Model.AtasNamaModel;
import com.example.kasir_bajawa.R;

import java.util.ArrayList;

public class AtasNamaAdapter extends RecyclerView.Adapter<AtasNamaAdapter.HomeViewHolder>{

    private ArrayList<AtasNamaModel> dataList;
    View viewku;

    public AtasNamaAdapter(ArrayList<AtasNamaModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        viewku = layoutInflater.inflate(R.layout.list_item_atasnama, parent, false);
        return new HomeViewHolder(viewku);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
            holder.txtnama.setText(dataList.get(position).getNamaC());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{
        private TextView txtnama;

        HomeViewHolder(View itemView) {
            super(itemView);
            txtnama = itemView.findViewById(R.id.txtNamaItem);

        }
    }

}
