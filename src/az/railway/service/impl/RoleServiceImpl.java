package az.railway.service.impl;

import az.railway.dao.interf.RoleDao;
import az.railway.model.Role;
import az.railway.service.interf.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getRoleList() throws Exception {
        return roleDao.getRoleList();
    }

    @Override
    public void addRole(Role role) throws Exception {
        roleDao.addRole(role);
    }

    @Override
    public Role getRoleById(Long roleId) throws Exception {
        return roleDao.getRoleById(roleId);
    }

    @Override
    public void updateRole(Role role) throws Exception {
        roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(Long roleId) throws Exception {
        roleDao.deleteRole(roleId);
    }

    @Override
    public List<Role> searchRoleData(String keyword) throws Exception {
        return roleDao.searchRoleData(keyword);
    }
}
