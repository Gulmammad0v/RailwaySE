package az.railway.model;

public class RouteType extends Railway {
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "RouteType{" +
                "Id='" + getId() + '\'' +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
