package az.railway.dao.interf;

import az.railway.model.UserRole;

import java.util.List;

public interface UserRoleDao {
    List<UserRole> getUserRoleList() throws Exception;
    void addUserRole(UserRole userRole) throws Exception;
}
