package com.example.kasir_bajawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.kasir_bajawa.Adapter.AtasNamaAdapter;
import com.example.kasir_bajawa.Adapter.HargaAdapter;
import com.example.kasir_bajawa.Adapter.JumlahAdapter;
import com.example.kasir_bajawa.Adapter.TotalAdapter;
import com.example.kasir_bajawa.Model.AtasNamaModel;
import com.example.kasir_bajawa.Model.HargaModel;
import com.example.kasir_bajawa.Model.HomeModel;
import com.example.kasir_bajawa.Model.JumlahModel;
import com.example.kasir_bajawa.Model.ProdukModel;
import com.example.kasir_bajawa.Model.TotalModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    private TextView tvAtasNama, tvTanggal, tvTotal;
    private ProgressDialog progressDialog;
    private ArrayList mProdukList = new ArrayList<ProdukModel>();
    private Button btnPost;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        recyclerViewNama = findViewById(R.id.rvNamaItem);
        recyclerViewHarga = findViewById(R.id.rvHarga);
        recyclerViewJumlah = findViewById(R.id.rvJumlah);
        recyclerViewTotal = findViewById(R.id.rvTotal);
        tvAtasNama = findViewById(R.id.txtAtasNama);
        tvTanggal = findViewById(R.id.txtTanggal);
        tvTotal = findViewById(R.id.txtTotals);
        btnPost = findViewById(R.id.btnPost);

        Intent intent = getIntent();
        HomeModel homeModel = intent.getParcelableExtra("Item Data");
        tvAtasNama.setText(homeModel.getNama());
        tvTanggal.setText(homeModel.getTanggal());
        id = homeModel.getId();

        atasNamaModels = new ArrayList<>();
        hargaModels = new ArrayList<>();
        jumlahModels = new ArrayList<>();
        totalModels = new ArrayList<>();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.show();

        AndroidNetworking.get(BaseUrl.url + "getproduk.php")
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
                                    JSONObject object = data.getJSONObject(i);

                                    ProdukModel model = new ProdukModel();
                                    model.setId(object.getString("id"));
                                    model.setKodeMakanan(object.getString("kodeMakanan"));
                                    model.setNamaMakanan(object.getString("namaMakanan"));

                                    mProdukList.add(model);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(CheckoutActivity.this, "error", Toast.LENGTH_SHORT).show();
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

        AndroidNetworking.post(BaseUrl.url + "getdetailnota.php")
                .addBodyParameter("kodeNota", homeModel.getKodeNota())
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

                                    atasNamaModels.add(new AtasNamaModel(item.getString("id"), item.getString("kodeMakanan")));
                                    hargaModels.add(new HargaModel(item.getString("id"), item.getString("hargaSatuan")));
                                    jumlahModels.add(new JumlahModel(item.getString("id"), item.getString("jumlahItem")));
                                    totalModels.add(new TotalModel(item.getString("id"), item.getString("subTotal")));
                                }

                                int total = 0;
                                for (int i = 0; i < totalModels.size(); i++) {
                                    total += Integer.valueOf(totalModels.get(i).getTotalC());
                                }
                                tvTotal.setText(String.valueOf(total));

                                progressDialog.dismiss();
                                atasNamaAdapter.notifyDataSetChanged();
                                hargaAdapter.notifyDataSetChanged();
                                jumlahAdapter.notifyDataSetChanged();
                                totalAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(CheckoutActivity.this, "error", Toast.LENGTH_SHORT).show();
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

        atasNamaAdapter = new AtasNamaAdapter(atasNamaModels, mProdukList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CheckoutActivity.this);
        recyclerViewNama.setLayoutManager(layoutManager);
        recyclerViewNama.setAdapter(atasNamaAdapter);

        hargaAdapter = new HargaAdapter(hargaModels);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(CheckoutActivity.this);
        recyclerViewHarga.setLayoutManager(layoutManager1);
        recyclerViewHarga.setAdapter(hargaAdapter);

        jumlahAdapter = new JumlahAdapter(jumlahModels);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(CheckoutActivity.this);
        recyclerViewJumlah.setLayoutManager(layoutManager2);
        recyclerViewJumlah.setAdapter(jumlahAdapter);

        totalAdapter = new TotalAdapter(totalModels);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(CheckoutActivity.this);
        recyclerViewTotal.setLayoutManager(layoutManager3);
        recyclerViewTotal.setAdapter(totalAdapter);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndroidNetworking.post(BaseUrl.url + "editnota.php")
                        .addBodyParameter("statusOrder", "selesai")
                        .addBodyParameter("id", id)
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject hasil = response.getJSONObject("hasil");
                                    boolean sukses = hasil.getBoolean("respon");
                                    if (sukses){
                                        Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }else {
                                        Toast.makeText(CheckoutActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }

                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(CheckoutActivity.this, "error", Toast.LENGTH_SHORT).show();
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

            }
        });
    }
}