package az.railway.model;

public class Station extends Railway {
    private String stationName;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public String toString() {
        return getId() + "." + getStationName();
    }
}
