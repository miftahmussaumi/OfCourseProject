package com.example.ofcourse;

public class responsemodelsearch {

    private String pendidikan, no_hp, ket_guru, nama_mapel, nama_guru, alamat;
    private  int id_guru, upah;

    public responsemodelsearch() {
    }

    public responsemodelsearch(String pendidikan, String no_hp, String ket_guru, String nama_mapel, String nama_guru, String alamat, int id_guru, int upah) {
        this.pendidikan = pendidikan;
        this.no_hp = no_hp;
        this.ket_guru = ket_guru;
        this.nama_mapel = nama_mapel;
        this.nama_guru = nama_guru;
        this.alamat = alamat;
        this.id_guru = id_guru;
        this.upah = upah;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getKet_guru() {
        return ket_guru;
    }

    public void setKet_guru(String ket_guru) {
        this.ket_guru = ket_guru;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getId_guru() {
        return id_guru;
    }

    public void setId_guru(int id_guru) {
        this.id_guru = id_guru;
    }

    public int getUpah() {
        return upah;
    }

    public void setUpah(int upah) {
        this.upah = upah;
    }
}
