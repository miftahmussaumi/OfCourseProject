package com.example.ofcourse.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseGuru implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
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

    public ResponseGuru(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        namaGuru = in.readString();
        pendidikan = in.readString();
        alamat = in.readString();
        noHp = in.readString();
        if (in.readByte() == 0) {
            upah = null;
        } else {
            upah = in.readInt();
        }
        ketGuru = in.readString();
        namaMapel = in.readString();
    }

    public static final Creator<ResponseGuru> CREATOR = new Creator<ResponseGuru>() {
        @Override
        public ResponseGuru createFromParcel(Parcel in) {
            return new ResponseGuru(in);
        }

        @Override
        public ResponseGuru[] newArray(int size) {
            return new ResponseGuru[size];
        }
    };

    public ResponseGuru() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ResponseGuru{" +
                "id=" + id +
                ", namaGuru='" + namaGuru + '\'' +
                ", pendidikan='" + pendidikan + '\'' +
                ", alamat='" + alamat + '\'' +
                ", noHp='" + noHp + '\'' +
                ", upah=" + upah +
                ", ketGuru='" + ketGuru + '\'' +
                ", namaMapel='" + namaMapel + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(namaGuru);
        dest.writeString(pendidikan);
        dest.writeString(alamat);
        dest.writeString(noHp);
        if (upah == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(upah);
        }
        dest.writeString(ketGuru);
        dest.writeString(namaMapel);
    }
}
