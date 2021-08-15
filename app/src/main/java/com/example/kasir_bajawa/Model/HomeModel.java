package com.example.kasir_bajawa.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class HomeModel implements Parcelable {
    String id;
    String nama;
    String next;
    String time;
    String tanggal;
    String kodeNota;

    public HomeModel(String id, String nama, String time, String next) {
        this.id = id;
        this.nama = nama;
        this.time = time;
    }

    public HomeModel() {

    }

    protected HomeModel(Parcel in) {
        id = in.readString();
        nama = in.readString();
        next = in.readString();
        time = in.readString();
        tanggal = in.readString();
        kodeNota = in.readString();
    }

    public static final Creator<HomeModel> CREATOR = new Creator<HomeModel>() {
        @Override
        public HomeModel createFromParcel(Parcel in) {
            return new HomeModel(in);
        }

        @Override
        public HomeModel[] newArray(int size) {
            return new HomeModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKodeNota() {
        return kodeNota;
    }

    public void setKodeNota(String kodeNota) {
        this.kodeNota = kodeNota;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(nama);
        parcel.writeString(next);
        parcel.writeString(time);
        parcel.writeString(tanggal);
        parcel.writeString(kodeNota);
    }
}
