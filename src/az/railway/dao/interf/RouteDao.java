package az.railway.dao.interf;

import az.railway.model.Route;

import java.util.List;

public interface RouteDao {
    List<Route> getRouteList() throws Exception;

    void addRoute(Route route) throws Exception;
}
