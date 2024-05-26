package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.RouteTypeDao;
import az.railway.model.RouteType;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RouteTypeDaoImpl implements RouteTypeDao {
    @Override
    public List<RouteType> getRouteTypeList() throws Exception {
        String sql = SelectConstant.GET_ROUTE_TYPE_LIST;
        List<RouteType> listRouteType = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                RouteType routeType = new RouteType();
                routeType.setId(rs.getLong("ID"));
                routeType.setTypeName(rs.getString("TYPE_NAME"));
                listRouteType.add(routeType);
            }
        }
        return listRouteType;
    }

    @Override
    public void addRouteType(RouteType routeType) throws Exception {
        String sql = InsertConstant.INSERT_ROUTE_TYPE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, routeType.getTypeName());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public RouteType getRouteTypeById(Long routeTypeId) throws Exception {
        String sql = SelectConstant.GET_ROUTE_TYPE_BY_ID;
        RouteType routeType = new RouteType();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, routeTypeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                routeType.setId(rs.getLong("ID"));
                routeType.setTypeName(rs.getString("TYPE_NAME"));
            }
        }
        return routeType;
    }

    @Override
    public void updateRouteType(RouteType routeType) throws Exception {
        String sql = UpdateConstant.UPDATE_ROUTE_TYPE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, routeType.getTypeName());
            ps.setLong(2, routeType.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteRouteType(Long routeTypeId) throws Exception {
        String sql = UpdateConstant.DELETE_ROUTE_TYPE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, routeTypeId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<RouteType> searchRouteTypeData(String keyword) throws Exception {
        String sql = SelectConstant.SEARCH_ROUTE_TYPE_DATA;
        List<RouteType> listRouteType = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RouteType routeType = new RouteType();
                routeType.setId(rs.getLong("ID"));
                routeType.setTypeName(rs.getString("TYPE_NAME"));
                listRouteType.add(routeType);
            }
        }
        return listRouteType;
    }
}
