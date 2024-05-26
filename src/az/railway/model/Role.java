package az.railway.model;

public class Role extends Railway {
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return getId() + "." + getRoleName();
    }
}
