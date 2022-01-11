package com.example.ofcourse.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseTransaksi {
    @SerializedName("id_transaksi")
    @Expose
    private Integer idTransaksi;
    @SerializedName("id_users")
    @Expose
    private Integer idUsers;
    @SerializedName("nama_guru")
    @Expose
    private String namaGuru;
    @SerializedName("tgl")
    @Expose
    private String tgl;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama_mapel")
    @Expose
    private String namaMapel;

    public Integer getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaMapel() {
        return namaMapel;
    }

    public void setNamaMapel(String namaMapel) {
        this.namaMapel = namaMapel;
    }
}
