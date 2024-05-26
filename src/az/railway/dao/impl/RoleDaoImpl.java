package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.RoleDao;
import az.railway.model.Role;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> getRoleList() throws Exception {
        String sql = SelectConstant.GET_ROLE_LIST;
        List<Role> listRole = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getLong("ID"));
                role.setRoleName(rs.getString("ROLE_NAME"));
                listRole.add(role);
            }
        }
        return listRole;
    }

    @Override
    public void addRole(Role role) throws Exception {
        String sql = InsertConstant.INSERT_ROLE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, role.getRoleName());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Role getRoleById(Long roleId) throws Exception {
        String sql = SelectConstant.GET_ROLE_BY_ID;
        Role role = new Role();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, roleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                role.setId(rs.getLong("ID"));
                role.setRoleName(rs.getString("ROLE_NAME"));
            }
        }
        return role;
    }

    @Override
    public void updateRole(Role role) throws Exception {
        String sql = UpdateConstant.UPDATE_ROLE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, role.getRoleName());
            ps.setLong(2, role.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteRole(Long roleId) throws Exception {
        String sql = UpdateConstant.DELETE_ROLE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, roleId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Role> searchRoleData(String keyword) throws Exception {
        String sql = SelectConstant.SEARCH_ROLE_DATA;
        List<Role> listRole = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getLong("ID"));
                role.setRoleName(rs.getString("ROLE_NAME"));
                listRole.add(role);
            }
        }
        return listRole;
    }
}
