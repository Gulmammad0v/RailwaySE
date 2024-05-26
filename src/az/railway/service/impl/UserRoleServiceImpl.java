package az.railway.service.impl;

import az.railway.dao.interf.UserRoleDao;
import az.railway.model.UserRole;
import az.railway.service.interf.UserRoleService;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {
    UserRoleDao userRoleDao;

    public UserRoleServiceImpl(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    @Override
    public List<UserRole> getUserRoleList() throws Exception {
        return userRoleDao.getUserRoleList();
    }

    @Override
    public void addUserRole(UserRole userRole) throws Exception {
        userRoleDao.addUserRole(userRole);
    }
}
