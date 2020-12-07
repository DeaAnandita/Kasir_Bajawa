package com.example.kasir_bajawa.Model;

public class JumlahModel {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJumlahC() {
        return jumlahC;
    }

    public void setJumlahC(String jumlahC) {
        this.jumlahC = jumlahC;
    }

    String jumlahC;

    public JumlahModel(String id, String jumlahC) {
        this.id = id;
        this.jumlahC = jumlahC;
    }


}
