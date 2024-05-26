package az.railway.model;

public class Wagon extends Railway {
    private String wagonName;
    private Class aClass;

    public String getWagonName() {
        return wagonName;
    }

    public void setWagonName(String wagonName) {
        this.wagonName = wagonName;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return getId() + "." + getWagonName();
    }
}
