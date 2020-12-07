package com.example.kasir_bajawa.Model;

public class HomeModel {

    String id;
    String nama;
    String next;
    String time;

    public HomeModel(String id, String nama, String time, String next) {
        this.id = id;
        this.nama = nama;
        this.time = time;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return next;
    }

    public void setEmail(String email) {
        this.next = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
