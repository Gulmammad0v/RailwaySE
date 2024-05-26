package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.PositionDao;
import az.railway.model.Position;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PositionDaoImpl implements PositionDao {
    @Override
    public List<Position> getPositionList() throws Exception {
        String sql = SelectConstant.GET_POSITION_LIST;
        List<Position> listPosition = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Position position = new Position();
                position.setId(rs.getLong("ID"));
                position.setPositionName(rs.getString("POSITION_NAME"));
                listPosition.add(position);
            }
        }
        return listPosition;
    }

    @Override
    public void addPosition(Position position) throws Exception {
        String sql = InsertConstant.INSERT_POSITION;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, position.getPositionName());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Position getPositionById(Long positionId) throws Exception {
        String sql = SelectConstant.GET_POSITION_BY_ID;
        Position position = new Position();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, positionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                position.setId(rs.getLong("ID"));
                position.setPositionName(rs.getString("POSITION_NAME"));
            }
        }
        return position;
    }

    @Override
    public void updatePosition(Position position) throws Exception {
        String sql = UpdateConstant.UPDATE_POSITION;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, position.getPositionName());
            ps.setLong(2, position.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deletePosition(Long positionId) throws Exception {
        String sql = UpdateConstant.DELETE_POSITION;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, positionId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Position> searchPosition(String keyword) throws Exception {
        String sql = SelectConstant.SEARCH_POSITION_DATA;
        List<Position> listPosition = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Position position = new Position();
                position.setId(rs.getLong("ID"));
                position.setPositionName(rs.getString("POSITION_NAME"));
                listPosition.add(position);
            }
        }
        return listPosition;
    }
}
