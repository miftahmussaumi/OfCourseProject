package com.example.ofcourse.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseReview implements Parcelable {
    @SerializedName("review")
    @Expose
    private String review;
    @SerializedName("nama_guru")
    @Expose
    private String namaGuru;
    @SerializedName("name")
    @Expose
    private String name;

    protected ResponseReview(Parcel in) {
        review = in.readString();
        namaGuru = in.readString();
        name = in.readString();
    }

    public static final Creator<ResponseReview> CREATOR = new Creator<ResponseReview>() {
        @Override
        public ResponseReview createFromParcel(Parcel in) {
            return new ResponseReview(in);
        }

        @Override
        public ResponseReview[] newArray(int size) {
            return new ResponseReview[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(review);
        dest.writeString(namaGuru);
        dest.writeString(name);
    }
}
