package com.example.kasir_bajawa.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kasir_bajawa.Model.AtasNamaModel;
import com.example.kasir_bajawa.Model.TotalModel;
import com.example.kasir_bajawa.R;

import java.util.ArrayList;

public class TotalAdapter extends RecyclerView.Adapter<TotalAdapter.HomeViewHolder>{

    private ArrayList<TotalModel> dataList;
    View viewku;

    public TotalAdapter(ArrayList<TotalModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        viewku = layoutInflater.inflate(R.layout.list_item_total, parent, false);
        return new HomeViewHolder(viewku);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
            holder.txtTotal.setText(dataList.get(position).getTotalC());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTotal;

        HomeViewHolder(View itemView) {
            super(itemView);
            txtTotal = itemView.findViewById(R.id.txtTotalC);

        }
    }

}
