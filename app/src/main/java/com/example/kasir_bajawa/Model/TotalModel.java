package com.example.kasir_bajawa.Model;

public class TotalModel {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotalC() {
        return totalC;
    }

    public void setTotalC(String totalC) {
        this.totalC = totalC;
    }

    String totalC;

    public TotalModel(String id, String totalC) {
        this.id = id;
        this.totalC = totalC;
    }


}
