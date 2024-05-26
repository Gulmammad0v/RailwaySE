package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.DirectionDao;
import az.railway.model.Direction;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DirectionDaoImpl implements DirectionDao {
    @Override
    public List<Direction> getDirectionList() throws Exception {
        String sql = SelectConstant.GET_DIRECTION_LIST;
        List<Direction> listDirection = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Direction direction = new Direction();
                direction.setId(rs.getLong("ID"));
                direction.setDirectionName(rs.getString("DIRECTION_NAME"));
                listDirection.add(direction);
            }
        }
        return listDirection;
    }
}
