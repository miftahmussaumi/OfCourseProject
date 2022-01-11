package com.example.ofcourse.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseReview implements Serializable {
    @SerializedName("review")
    @Expose
    private String review;
    @SerializedName("nama_guru")
    @Expose
    private String namaGuru;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ResponseReview{" +
                "review='" + review + '\'' +
                ", namaGuru='" + namaGuru + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
