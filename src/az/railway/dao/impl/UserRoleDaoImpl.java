package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.UserRoleDao;
import az.railway.model.Role;
import az.railway.model.User;
import az.railway.model.UserRole;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDaoImpl implements UserRoleDao {
    @Override
    public List<UserRole> getUserRoleList() throws Exception {
        String sql = SelectConstant.GET_USER_ROLE_LIST;
        List<UserRole> listUserRole = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                UserRole userRole = new UserRole();
                User user = new User();
                userRole.setId(rs.getLong("USER_ROLE_ID"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setSurname(rs.getString("SURNAME"));
                Role role = new Role();
                role.setRoleName(rs.getString("ROLE_NAME"));
                userRole.setRole(role);
                userRole.setUser(user);
                listUserRole.add(userRole);
            }
        }
        return listUserRole;
    }

    @Override
    public void addUserRole(UserRole userRole) throws Exception {
        String sql = InsertConstant.INSERT_USER_ROLE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, userRole.getRole().getId());
            ps.setLong(2, userRole.getUser().getId());
            ps.execute();
            c.commit();
        }
    }
}
