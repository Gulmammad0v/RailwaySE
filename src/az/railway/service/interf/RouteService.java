package az.railway.service.interf;

import az.railway.model.Route;

import java.util.List;

public interface RouteService {
    List<Route> getRouteList() throws Exception;

    void addRoute(Route route) throws Exception;
}
