package com.example.kasir_bajawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.kasir_bajawa.Adapter.HomeAdapter;
import com.example.kasir_bajawa.Model.HomeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    ArrayList<HomeModel> homeModels;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        recyclerView = findViewById(R.id.rvMain);
        homeModels = new ArrayList<>();

        progressDialog.setTitle("Loading...");
        progressDialog.show();
        AndroidNetworking.post(BaseUrl.url + "getnota.php")
                .addBodyParameter("statusOrder", "orderDiterima")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("STATUS");

                            if (status.equals("SUCCESS")) {
                                JSONArray data = response.getJSONArray("PAYLOAD");

                                for (int i = 0; i < data.length(); i++) {
                                    JSONObject item = data.getJSONObject(i);

                                    HomeModel homeModel = new HomeModel();
                                    homeModel.setId(item.getString("id"));
                                    homeModel.setNama(item.getString("namaCustomer"));
                                    homeModel.setTanggal(item.getString("tanggalNota"));
                                    homeModel.setKodeNota(item.getString("id"));
                                    homeModel.setTime("09:00");

                                    homeModels.add(homeModel);
                                }

                                progressDialog.dismiss();
                                homeAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                        if (anError.getErrorCode() != 0) {
                            Log.d("TAG", "onError errorCode : " + anError.getErrorCode());
                            Log.d("TAG", "onError errorBody : " + anError.getErrorBody());
                            Log.d("TAG", "onError errorDetail : " + anError.getErrorDetail());
                        } else {
                            Log.d("TAG", "onError errorDetail : " + anError.getErrorDetail());
                        }
                    }
                });

        homeAdapter = new HomeAdapter(homeModels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeAdapter);
    }
}