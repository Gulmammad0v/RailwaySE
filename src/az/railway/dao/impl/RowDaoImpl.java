package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.RowDao;
import az.railway.model.Class;
import az.railway.model.Row;
import az.railway.model.Wagon;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RowDaoImpl implements RowDao {
    @Override
    public List<Row> getRowList() throws Exception {
        String sql = SelectConstant.GET_ROW_LIST;
        List<Row> listRow = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Row row = new Row();
                row.setId(rs.getLong("ROW_ID"));
                row.setRowName(rs.getInt("ROW_NAME"));
                Wagon wagon = new Wagon();
                wagon.setWagonName(rs.getString("WAGON_NAME"));
                Class aClass = new Class();
                aClass.setClassName(rs.getString("CLASS_NAME"));
                row.setWagon(wagon);
                row.setaClass(aClass);
                listRow.add(row);
            }
        }
        return listRow;
    }

    @Override
    public void addRow(Row row) throws Exception {
        String sql = InsertConstant.INSERT_ROW;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, row.getRowName());
            ps.setLong(2, row.getWagon().getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Row getRowById(Long rowId) throws Exception {
        String sql = SelectConstant.GET_ROW_BY_ID;
        Row row = new Row();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, rowId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                row.setId(rs.getLong("ROW_ID"));
                row.setRowName(rs.getInt("ROW_NAME"));
                Wagon wagon = new Wagon();
                wagon.setWagonName(rs.getString("WAGON_NAME"));
                Class aClass = new Class();
                aClass.setClassName(rs.getString("CLASS_NAME"));
                row.setWagon(wagon);
                row.setaClass(aClass);
            }
        }
        return row;
    }
}
