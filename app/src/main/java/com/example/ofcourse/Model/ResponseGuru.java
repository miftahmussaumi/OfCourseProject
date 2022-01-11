package com.example.ofcourse.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseGuru implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_guru")
    @Expose
    private Integer idGuru;
    @SerializedName("nama_guru")
    @Expose
    private String namaGuru;
    @SerializedName("pendidikan")
    @Expose
    private String pendidikan;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("no_hp")
    @Expose
    private String noHp;
    @SerializedName("upah")
    @Expose
    private Integer upah;
    @SerializedName("ket_guru")
    @Expose
    private String ketGuru;
    @SerializedName("nama_mapel")
    @Expose
    private String namaMapel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(Integer idGuru) {
        this.idGuru = idGuru;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public Integer getUpah() {
        return upah;
    }

    public void setUpah(Integer upah) {
        this.upah = upah;
    }

    public String getKetGuru() {
        return ketGuru;
    }

    public void setKetGuru(String ketGuru) {
        this.ketGuru = ketGuru;
    }

    public String getNamaMapel() {
        return namaMapel;
    }

    public void setNamaMapel(String namaMapel) {
        this.namaMapel = namaMapel;
    }
}
