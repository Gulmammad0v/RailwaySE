package az.railway.service.impl;

import az.railway.dao.interf.RouteDao;
import az.railway.model.Route;
import az.railway.service.interf.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    RouteDao routeDao;

    public RouteServiceImpl(RouteDao routeDao) {
        this.routeDao = routeDao;
    }

    @Override
    public List<Route> getRouteList() throws Exception {
        return routeDao.getRouteList();
    }

    @Override
    public void addRoute(Route route) throws Exception {
        routeDao.addRoute(route);
    }
}
