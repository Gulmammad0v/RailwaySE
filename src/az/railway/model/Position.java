package az.railway.model;

public class Position extends Railway {
    private String positionName;

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return getId() + "." + getPositionName();
    }
}
