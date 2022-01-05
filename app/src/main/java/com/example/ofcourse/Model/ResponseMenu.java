package com.example.ofcourse.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseMenu implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama_mapel")
    @Expose
    private String namaMapel;
    @SerializedName("gambar_mapel")
    @Expose
    private String gambarMapel;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

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

    public String getGambarMapel() {
        return gambarMapel;
    }

    public void setGambarMapel(String gambarMapel) {
        this.gambarMapel = gambarMapel;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
