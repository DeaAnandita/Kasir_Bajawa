package com.example.kasir_bajawa.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kasir_bajawa.CheckoutActivity;
import com.example.kasir_bajawa.LoginActivity;
import com.example.kasir_bajawa.MainActivity;
import com.example.kasir_bajawa.Model.HomeModel;
import com.example.kasir_bajawa.R;

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
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, int position) {
        holder.txtnama.setText(dataList.get(position).getNama());
        holder.txtTime.setText(dataList.get(position).getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), CheckoutActivity.class);
                intent.putExtra("Item Data", dataList.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
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
