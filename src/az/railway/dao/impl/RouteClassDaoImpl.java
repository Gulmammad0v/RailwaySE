package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.RouteClassDao;
import az.railway.model.*;
import az.railway.model.Class;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RouteClassDaoImpl implements RouteClassDao {
    @Override
    public List<RouteClass> getRouteClassList() throws Exception {
        String sql = SelectConstant.GET_ROUTE_CLASS_LIST;
        List<RouteClass> listRouteClass = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                RouteClass routeClass = new RouteClass();
                routeClass.setId(rs.getLong("ROUTE_CLASS_ID"));
                Station station = new Station();
                station.setStationName(rs.getString("BEGIN_STATION"));
                Station station2 = new Station();
                station2.setStationName(rs.getString("END_STATION"));
                Class aClass = new Class();
                aClass.setClassName(rs.getString("CLASS_NAME"));
                routeClass.setRoutePrice(rs.getFloat("ROUTE_PRICE"));
                RouteType routeType = new RouteType();
                routeType.setTypeName(rs.getString("ROUTE_TYPE"));
                Direction direction = new Direction();
                direction.setDirectionName(rs.getString("DIRECTION_NAME"));
                routeClass.setBeginStation(station);
                routeClass.setEndStation(station2);
                routeClass.setaClass(aClass);
                routeClass.setRouteType(routeType);
                routeClass.setDirection(direction);
                listRouteClass.add(routeClass);
            }
        }
        return listRouteClass;
    }

    @Override
    public void addRouteClass(RouteClass routeClass) throws Exception {
        String sql = InsertConstant.INSERT_ROUTE_CLASS;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, routeClass.getRoute().getId());
            ps.setLong(2, routeClass.getaClass().getId());
            ps.setFloat(3, routeClass.getRoutePrice());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public RouteClass routeClassById(Long routeClassId) throws Exception {
        String sql = SelectConstant.GET_ROUTE_CLASS_BY_ID;
        RouteClass routeClass = new RouteClass();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, routeClassId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                routeClass.setId(rs.getLong("ROUTE_CLASS_ID"));
                Station station = new Station();
                station.setStationName(rs.getString("BEGIN_STATION"));
                Station station2 = new Station();
                station2.setStationName(rs.getString("END_STATION"));
                Class aClass = new Class();
                aClass.setClassName(rs.getString("CLASS_NAME"));
                routeClass.setRoutePrice(rs.getFloat("ROUTE_PRICE"));
                RouteType routeType = new RouteType();
                routeType.setTypeName(rs.getString("ROUTE_TYPE"));
                Direction direction = new Direction();
                direction.setDirectionName(rs.getString("DIRECTION_NAME"));
                routeClass.setBeginStation(station);
                routeClass.setEndStation(station2);
                routeClass.setaClass(aClass);
                routeClass.setRouteType(routeType);
                routeClass.setDirection(direction);
            }
        }
        return routeClass;
    }
}
