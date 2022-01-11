package com.example.ofcourse;

public class responsemodel {

    private String id, nama_mapel, gambar_mapel, created_at, updated_at;

    public responsemodel() {
    }

    public responsemodel(String id, String nama_mapel, String gambar_mapel, String created_at, String updated_at) {
        this.id = id;
        this.nama_mapel = nama_mapel;
        this.gambar_mapel = gambar_mapel;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public String getGambar_mapel() {
        return gambar_mapel;
    }

    public void setGambar_mapel(String gambar_mapel) {
        this.gambar_mapel = gambar_mapel;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
