package com.example.kasir_bajawa.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kasir_bajawa.Model.AtasNamaModel;
import com.example.kasir_bajawa.Model.JumlahModel;
import com.example.kasir_bajawa.R;

import java.util.ArrayList;

public class JumlahAdapter extends RecyclerView.Adapter<JumlahAdapter.HomeViewHolder>{

    private ArrayList<JumlahModel> dataList;
    View viewku;

    public JumlahAdapter(ArrayList<JumlahModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        viewku = layoutInflater.inflate(R.layout.list_item_jumlah, parent, false);
        return new HomeViewHolder(viewku);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
            holder.txtJumlah.setText(dataList.get(position).getJumlahC());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{
        private TextView txtJumlah;

        HomeViewHolder(View itemView) {
            super(itemView);
            txtJumlah = itemView.findViewById(R.id.txtJumlahC);

        }
    }

}
