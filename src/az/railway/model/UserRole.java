package az.railway.model;

public class UserRole extends Railway {
    private User user;
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return getUser().getPassword()+":"+getRole().getRoleName();
    }
}
