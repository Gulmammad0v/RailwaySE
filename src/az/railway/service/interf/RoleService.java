package az.railway.service.interf;

import az.railway.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList() throws Exception;

    void addRole(Role role) throws Exception;

    Role getRoleById(Long roleId) throws Exception;

    void updateRole(Role role) throws Exception;

    void deleteRole(Long roleId) throws Exception;

    List<Role> searchRoleData(String keyword) throws Exception;
}
