package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.WagonDao;
import az.railway.model.Class;
import az.railway.model.Wagon;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WagonDaoImpl implements WagonDao {
    @Override
    public List<Wagon> getWagonList() throws Exception {
        String sql = SelectConstant.GET_WAGON_LIST;
        List<Wagon> listWagon = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Wagon wagon = new Wagon();
                wagon.setId(rs.getLong("WAGON_ID"));
                wagon.setWagonName(rs.getString("WAGON_NAME"));
                Class aClass = new Class();
                aClass.setClassName(rs.getString("CLASS_NAME"));
                wagon.setaClass(aClass);
                listWagon.add(wagon);
            }
        }
        return listWagon;
    }

    @Override
    public void addWagon(Wagon wagon) throws Exception {
        String sql = InsertConstant.INSERT_WAGON;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, wagon.getWagonName());
            ps.setLong(2, wagon.getaClass().getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Wagon getWagonById(Long wagonId) throws Exception {
        String sql = SelectConstant.GET_WAGON_BY_ID;
        Wagon wagon = new Wagon();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, wagonId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                wagon.setId(rs.getLong("WAGON_ID"));
                wagon.setWagonName(rs.getString("WAGON_NAME"));
                Class aClass = new Class();
                aClass.setClassName(rs.getString("CLASS_NAME"));
                wagon.setaClass(aClass);
            }
        }
        return wagon;
    }
}
