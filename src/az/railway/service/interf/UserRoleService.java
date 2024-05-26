package az.railway.service.interf;

import az.railway.model.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getUserRoleList() throws Exception;
    void addUserRole(UserRole userRole) throws Exception;
}
