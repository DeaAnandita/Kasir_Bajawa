package com.example.kasir_bajawa.Model;

public class HargaModel {
    String id;
    String hargaC;

    public HargaModel(String id, String hargaC) {
        this.id = id;
        this.hargaC = hargaC;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHargaC() {
        return hargaC;
    }

    public void setHargaC(String hargaC) {
        this.hargaC = hargaC;
    }
}
