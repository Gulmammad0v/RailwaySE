package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.UserDao;
import az.railway.model.User;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getUserList() throws Exception {
        String sql = SelectConstant.GET_USER_LIST;
        List<User> listUser = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setName(rs.getString("NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setDob(rs.getDate("DOB"));
                user.setPin(rs.getString("PIN"));
                user.setPhone(rs.getString("PHONE"));
                user.setEmail(rs.getString("E_MAIL"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setPassword(rs.getString("PASSWORD"));
                listUser.add(user);
            }
        }
        return listUser;
    }

    @Override
    public void addUser(User user) throws Exception {
        String sql = InsertConstant.INSERT_USER;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
            ps.setString(4, user.getPin());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getUserName());
            ps.setString(8, user.getPassword());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        String sql = SelectConstant.GET_USER_BY_ID;
        User user = new User();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getLong("ID"));
                user.setName(rs.getString("NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setDob(rs.getDate("DOB"));
                user.setPin(rs.getString("PIN"));
                user.setPhone(rs.getString("PHONE"));
                user.setEmail(rs.getString("E_MAIL"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setPassword(rs.getString("PASSWORD"));
            }
        }
        return user;
    }

    @Override
    public void updateUser(User user) throws Exception {
        String sql = UpdateConstant.UPDATE_USER;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
            ps.setString(4, user.getPin());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getUserName());
            ps.setString(8, user.getPassword());
            ps.setLong(9, user.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        String sql = UpdateConstant.DELETE_USER;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, userId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<User> searchUserData(String keyword) throws Exception {
        String sql = SelectConstant.SEARCH_USER_DATA;
        List<User> listUser = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setName(rs.getString("NAME"));
                user.setSurname(rs.getString("SURNAME"));
                user.setDob(rs.getDate("DOB"));
                user.setPin(rs.getString("PIN"));
                user.setPhone(rs.getString("PHONE"));
                user.setEmail(rs.getString("E_MAIL"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setPassword(rs.getString("PASSWORD"));
                listUser.add(user);
            }
        }
        return listUser;
    }
}
