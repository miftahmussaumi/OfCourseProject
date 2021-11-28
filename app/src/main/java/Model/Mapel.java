package Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Mapel implements Parcelable {
    public String lm_photo;
    public String lm_mapel;
    public String lm_lokasi;
    public String lm_score;
    public String lm_guru;

    public Mapel(){

    }

    public Mapel(String lm_guru, String lm_mapel, String lm_lokasi, String lm_score, String lm_photo){
        this.lm_guru = lm_guru;
        this.lm_lokasi = lm_lokasi;
        this.lm_mapel = lm_mapel;
        this.lm_photo = lm_photo;
        this.lm_score = lm_score;
    }

    protected Mapel(Parcel in) {
        lm_photo = in.readString();
        lm_mapel = in.readString();
        lm_lokasi = in.readString();
        lm_score = in.readString();
        lm_guru = in.readString();
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

    public String getLm_photo() {
        return lm_photo;
    }

    public void setLm_photo(String lm_photo) {
        this.lm_photo = lm_photo;
    }

    public String getLm_mapel() {
        return lm_mapel;
    }

    public void setLm_mapel(String lm_mapel) {
        this.lm_mapel = lm_mapel;
    }

    public String getLm_lokasi() {
        return lm_lokasi;
    }

    public void setLm_lokasi(String lm_lokasi) {
        this.lm_lokasi = lm_lokasi;
    }

    public String getLm_score() {
        return lm_score;
    }

    public void setLm_score(String lm_score) {
        this.lm_score = lm_score;
    }

    public String getLm_guru() {
        return lm_guru;
    }

    public void setLm_guru(String lm_guru) {
        this.lm_guru = lm_guru;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lm_photo);
        dest.writeString(lm_mapel);
        dest.writeString(lm_lokasi);
        dest.writeString(lm_score);
        dest.writeString(lm_guru);
    }
}
