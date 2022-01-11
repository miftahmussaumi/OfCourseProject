package com.example.ofcourse.Model;

import com.google.gson.annotations.SerializedName;

public class Reservasi {
    @SerializedName("ket_tambahan")
    private String ketTambahan;

    @SerializedName("id_users")
    private String idUsers;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id_guru")
    private int idGuru;

    @SerializedName("jam_kls")
    private String jamKls;

    @SerializedName("lokasi_kls")
    private String lokasiKls;

    @SerializedName("total")
    private int total;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("review")
    private String review;

    @SerializedName("tgl")
    private String tgl;

    @SerializedName("id")
    private int id;

    @SerializedName("durasi")
    private String durasi;

    @SerializedName("bintang")
    private int bintang;

    @SerializedName("status")
    private String status;

    public void setKetTambahan(String ketTambahan){
        this.ketTambahan = ketTambahan;
    }

    public String getKetTambahan(){
        return ketTambahan;
    }

    public void setIdUsers(String idUsers){
        this.idUsers = idUsers;
    }

    public String getIdUsers(){
        return idUsers;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setIdGuru(int idGuru){
        this.idGuru = idGuru;
    }

    public int getIdGuru(){
        return idGuru;
    }

    public void setJamKls(String jamKls){
        this.jamKls = jamKls;
    }

    public String getJamKls(){
        return jamKls;
    }

    public void setLokasiKls(String lokasiKls){
        this.lokasiKls = lokasiKls;
    }

    public String getLokasiKls(){
        return lokasiKls;
    }

    public void setTotal(int total){
        this.total = total;
    }

    public int getTotal(){
        return total;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setReview(String review){
        this.review = review;
    }

    public String getReview(){
        return review;
    }

    public void setTgl(String tgl){
        this.tgl = tgl;
    }

    public String getTgl(){
        return tgl;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setDurasi(String durasi){
        this.durasi = durasi;
    }

    public String getDurasi(){
        return durasi;
    }

    public void setBintang(int bintang){
        this.bintang = bintang;
    }

    public int getBintang(){
        return bintang;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
