package com.example.kasir_bajawa.Model;

public class AtasNamaModel {
    String id;
    String namaC;

    public AtasNamaModel(String id, String namaC) {
        this.id = id;
        this.namaC = namaC;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaC() {
        return namaC;
    }

    public void setNamaC(String namaC) {
        this.namaC = namaC;
    }
}
