package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.RouteDao;
import az.railway.model.Direction;
import az.railway.model.Route;
import az.railway.model.RouteType;
import az.railway.model.Station;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    @Override
    public List<Route> getRouteList() throws Exception {
        String sql = SelectConstant.GET_ROUTE_LIST;
        List<Route> listRoute = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Route route = new Route();
                Station beginStation = new Station();
                Station endStation = new Station();
                RouteType routeType = new RouteType();
                Direction direction = new Direction();
                route.setId(rs.getLong("ROUTE_ID"));
                beginStation.setStationName(rs.getString("BEGIN_STATION"));
                endStation.setStationName(rs.getString("END_STATION"));
                routeType.setTypeName(rs.getString("ROUTE_TYPE_NAME"));
                direction.setDirectionName(rs.getString("DIRECTION_NAME"));
                route.setDirection(direction);
                route.setBeginStation(beginStation);
                route.setEndStation(endStation);
                route.setRouteType(routeType);
                listRoute.add(route);
            }
        }
        return listRoute;
    }

    @Override
    public void addRoute(Route route) throws Exception {
        String sql = InsertConstant.INSERT_ROUTE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, route.getBeginStation().getId());
            ps.setLong(2, route.getEndStation().getId());
            ps.setLong(3, route.getRouteType().getId());
            ps.setLong(4, route.getDirection().getId());
            ps.execute();
            c.commit();
        }
    }

}
