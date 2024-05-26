package az.railway.service.impl;

import az.railway.dao.interf.RouteClassDao;
import az.railway.model.RouteClass;
import az.railway.service.interf.RouteClassService;

import java.util.List;

public class RouteClassServiceImpl implements RouteClassService {
    RouteClassDao routeClassDao;

    public RouteClassServiceImpl(RouteClassDao routeClassDao) {
        this.routeClassDao = routeClassDao;
    }

    @Override
    public List<RouteClass> getRouteClassList() throws Exception {
        return routeClassDao.getRouteClassList();
    }

    @Override
    public void addRouteClass(RouteClass routeClass) throws Exception {
        routeClassDao.addRouteClass(routeClass);
    }

    @Override
    public RouteClass getRouteClassById(Long routeClassId) throws Exception {
        return routeClassDao.routeClassById(routeClassId);
    }
}
