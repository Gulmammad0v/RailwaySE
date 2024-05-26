package az.railway.model;

public class Train extends Railway {
    private Integer trainNumber;
    private Direction direction;

    public Integer getTrainNumber() {
        return trainNumber;
    }
    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return getId() + "." + getTrainNumber();
    }
}
