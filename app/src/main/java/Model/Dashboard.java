package Model;

public class Dashboard {
    String mapel;
    String pict;

    public Dashboard(String mapel, String pict){
        this.mapel = mapel;
        this.pict = pict;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getPict() {
        return pict;
    }

    public void setPict(String pict) {
        this.pict = pict;
    }
}
