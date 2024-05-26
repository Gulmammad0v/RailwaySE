package az.railway.model;

public class Class extends Railway {
    private String ClassName;

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    @Override
    public String toString() {
        return "Id='" + getId() + '\'' +" "+
                "ClassName='" + ClassName + '\'';
    }
}
