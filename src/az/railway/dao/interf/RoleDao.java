package az.railway.dao.interf;

import az.railway.model.Class;
import az.railway.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRoleList() throws Exception;

    void addRole(Role role) throws Exception;

    Role getRoleById(Long roleId) throws Exception;

    void updateRole(Role role) throws Exception;

    void deleteRole(Long roleId) throws Exception;

    List<Role> searchRoleData(String keyword) throws Exception;
}
