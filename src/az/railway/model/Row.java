package az.railway.model;

public class Row extends Railway {
    private Integer rowName;
    private Wagon wagon;
    private Class aClass;

    public Integer getRowName() {
        return rowName;
    }

    public void setRowName(Integer rowName) {
        this.rowName = rowName;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return getId() + ". Row Name : " + getRowName();
    }
}
