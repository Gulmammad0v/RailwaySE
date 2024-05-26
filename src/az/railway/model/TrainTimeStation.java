package az.railway.model;

public class TrainTimeStation extends Railway {
    private Station station;
    private Train train;
    private String time;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return getTrain().getTrainNumber() + " -> " + getTime() + " -> " + getStation().getStationName();
    }
}
