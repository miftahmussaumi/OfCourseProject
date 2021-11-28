package Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pencarian implements Parcelable {
    public String p_photo;
    public String p_mapel;
    public String p_lokasi;
    public String p_score;
    public String p_guru;

    public Pencarian(){

    }

    public Pencarian(String p_guru, String p_mapel, String p_lokasi, String p_score, String p_photo){
        this.p_guru = p_guru;
        this.p_lokasi = p_lokasi;
        this.p_mapel = p_mapel;
        this.p_photo = p_photo;
        this.p_score = p_score;
    }

    protected Pencarian(Parcel in) {
        p_photo = in.readString();
        p_mapel = in.readString();
        p_lokasi = in.readString();
        p_score = in.readString();
        p_guru = in.readString();
    }

    public static final Creator<Mapel> CREATOR = new Creator<Mapel>() {
        @Override
        public Mapel createFromParcel(Parcel in) {
            return new Mapel(in);
        }

        @Override
        public Mapel[] newArray(int size) {
            return new Mapel[size];
        }
    };

    public String getP_photo() {
        return p_photo;
    }

    public void setP_photo(String p_photo) {
        this.p_photo = p_photo;
    }

    public String getP_mapel() {
        return p_mapel;
    }

    public void setP_mapel(String p_mapel) {
        this.p_mapel = p_mapel;
    }

    public String getP_lokasi() {
        return p_lokasi;
    }

    public void setP_lokasi(String p_lokasi) {
        this.p_lokasi = p_lokasi;
    }

    public String getP_score() {
        return p_score;
    }

    public void setP_score(String p_score) {
        this.p_score = p_score;
    }

    public String getP_guru() {
        return p_guru;
    }

    public void setP_guru(String p_guru) {
        this.p_guru = p_guru;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(p_photo);
        dest.writeString(p_mapel);
        dest.writeString(p_lokasi);
        dest.writeString(p_score);
        dest.writeString(p_guru);
    }
}
