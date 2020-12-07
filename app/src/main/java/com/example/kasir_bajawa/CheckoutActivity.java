package com.example.kasir_bajawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kasir_bajawa.Adapter.AtasNamaAdapter;
import com.example.kasir_bajawa.Adapter.HargaAdapter;
import com.example.kasir_bajawa.Adapter.JumlahAdapter;
import com.example.kasir_bajawa.Adapter.TotalAdapter;
import com.example.kasir_bajawa.Model.AtasNamaModel;
import com.example.kasir_bajawa.Model.HargaModel;
import com.example.kasir_bajawa.Model.JumlahModel;
import com.example.kasir_bajawa.Model.TotalModel;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    RecyclerView recyclerViewNama;
    RecyclerView recyclerViewHarga;
    RecyclerView recyclerViewJumlah;
    RecyclerView recyclerViewTotal;

    AtasNamaAdapter atasNamaAdapter;
    HargaAdapter hargaAdapter;
    JumlahAdapter jumlahAdapter ;
    TotalAdapter totalAdapter;

    ArrayList<AtasNamaModel> atasNamaModels;
    ArrayList<HargaModel> hargaModels;
    ArrayList<JumlahModel> jumlahModels;
    ArrayList<TotalModel> totalModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        recyclerViewNama = findViewById(R.id.rvNamaItem);
        recyclerViewHarga = findViewById(R.id.rvHarga);
        recyclerViewJumlah = findViewById(R.id.rvJumlah);
        recyclerViewTotal = findViewById(R.id.rvTotal);

        atasNamaModels = new ArrayList<>();
        atasNamaModels.add(new AtasNamaModel("1", "choco"));
        atasNamaModels.add(new AtasNamaModel("2","Susu Caramel"));
        atasNamaModels.add(new AtasNamaModel("3", "Dea Anandita"));
        atasNamaModels.add(new AtasNamaModel("4","Susu Caramel"));
        atasNamaAdapter = new AtasNamaAdapter(atasNamaModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CheckoutActivity.this);
        recyclerViewNama.setLayoutManager(layoutManager);
        recyclerViewNama.setAdapter(atasNamaAdapter);

        hargaModels = new ArrayList<>();
        hargaModels.add(new HargaModel("1", "12.000"));
        hargaModels.add(new HargaModel("2","15.000"));
        hargaModels.add(new HargaModel("3", "20.000"));
        hargaModels.add(new HargaModel("4","40.000"));
        hargaAdapter = new HargaAdapter(hargaModels);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(CheckoutActivity.this);
        recyclerViewHarga.setLayoutManager(layoutManager1);
        recyclerViewHarga.setAdapter(hargaAdapter);

        jumlahModels = new ArrayList<>();
        jumlahModels.add(new JumlahModel("1", "1"));
        jumlahModels.add(new JumlahModel("2","1"));
        jumlahModels.add(new JumlahModel("3", "2"));
        jumlahModels.add(new JumlahModel("4","4"));
        jumlahAdapter = new JumlahAdapter(jumlahModels);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(CheckoutActivity.this);
        recyclerViewJumlah.setLayoutManager(layoutManager2);
        recyclerViewJumlah.setAdapter(jumlahAdapter);

        totalModels = new ArrayList<>();
        totalModels.add(new TotalModel("1", "14.000"));
        totalModels.add(new TotalModel("2","15.000"));
        totalModels.add(new TotalModel("3", "40.000"));
        totalModels.add(new TotalModel("4","40.000"));
        totalAdapter = new TotalAdapter(totalModels);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(CheckoutActivity.this);
        recyclerViewTotal.setLayoutManager(layoutManager3);
        recyclerViewTotal.setAdapter(totalAdapter);
    }
}