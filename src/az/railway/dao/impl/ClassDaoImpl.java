package az.railway.dao.impl;

import az.railway.dao.interf.ClassDao;
import az.railway.dao.DbHelper;
import az.railway.model.Class;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoImpl implements ClassDao {
    @Override
    public List<Class> getClassList() throws Exception {
        String sql = SelectConstant.GET_CLASS_LIST;
        List<Class> listClass = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Class clas = new Class();
                clas.setId(rs.getLong("ID"));
                clas.setClassName(rs.getString("CLASS_NAME"));
                listClass.add(clas);
            }
        }
        return listClass;
    }

    @Override
    public void addClass(Class clas) throws Exception {
        String sql = InsertConstant.INSERT_CLASS;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, clas.getClassName());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Class getClassById(Long classId) throws Exception {
        Class clas = new Class();
        String sql = SelectConstant.GET_CLASS_BY_ID;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, classId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clas.setId(rs.getLong("ID"));
                clas.setClassName(rs.getString("CLASS_NAME"));
            }
        }
        return clas;
    }

    @Override
    public void updateClass(Class clas) throws Exception {
        String sql = UpdateConstant.UPDATE_CLASS;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, clas.getClassName());
            ps.setLong(2, clas.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteClass(Long classId) throws Exception {
        String sql = UpdateConstant.DELETE_CLASS;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, classId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Class> searchClassData(String keyword) throws Exception {
        String sql = SelectConstant.SEARCH_CLASS_DATA;
        List<Class> listClass = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Class clas = new Class();
                clas.setId(rs.getLong("ID"));
                clas.setClassName(rs.getString("CLASS_NAME"));
                listClass.add(clas);
            }
        }
        return listClass;
    }
}
