package com.example.kasir_bajawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kasir_bajawa.Adapter.HomeAdapter;
import com.example.kasir_bajawa.Model.HomeModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    ArrayList<HomeModel> homeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMain);

        homeModels = new ArrayList<>();
        homeModels.add(new HomeModel("1", "Dea Anandita", "09:00",""));
        homeModels.add(new HomeModel("2", "Dea Anandita", "08:30", ""));
        homeModels.add(new HomeModel("3", "Dea Anandita", "08:20",""));
        homeModels.add(new HomeModel("4", "Dea Anandita", "08:00", ""));
        homeModels.add(new HomeModel("5", "Dea Anandita", "09:00",""));
        homeModels.add(new HomeModel("6", "Dea Anandita", "08:30", ""));
        homeModels.add(new HomeModel("7", "Dea Anandita", "08:20",""));
        homeModels.add(new HomeModel("8", "Dea Anandita", "08:00", ""));
        homeModels.add(new HomeModel("9", "Dea Anandita", "09:00",""));
        homeModels.add(new HomeModel("10", "Dea Anandita", "08:30", ""));
        homeModels.add(new HomeModel("11", "Dea Anandita", "08:20",""));
        homeModels.add(new HomeModel("12", "Dea ", "08:00", ""));

        homeAdapter = new HomeAdapter(homeModels);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(homeAdapter);
    }
}