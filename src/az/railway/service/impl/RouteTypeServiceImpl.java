package az.railway.service.impl;

import az.railway.dao.interf.RouteTypeDao;
import az.railway.model.RouteType;
import az.railway.service.interf.RouteTypeService;

import java.util.List;

public class RouteTypeServiceImpl implements RouteTypeService {
    RouteTypeDao routeTypeDao;

    public RouteTypeServiceImpl(RouteTypeDao routeTypeDao) {
        this.routeTypeDao = routeTypeDao;
    }

    @Override
    public List<RouteType> getRouteTypeList() throws Exception {
        return routeTypeDao.getRouteTypeList();
    }

    @Override
    public void addRouteType(RouteType routeType) throws Exception {
        routeTypeDao.addRouteType(routeType);
    }

    @Override
    public RouteType getRouteTypeById(Long routeTypeId) throws Exception {
        return routeTypeDao.getRouteTypeById(routeTypeId);
    }

    @Override
    public void updateRouteType(RouteType routeType) throws Exception {
        routeTypeDao.updateRouteType(routeType);
    }

    @Override
    public void deleteRouteType(Long routeTypeId) throws Exception {
        routeTypeDao.deleteRouteType(routeTypeId);
    }

    @Override
    public List<RouteType> searchRouteTypeData(String keyword) throws Exception {
        return routeTypeDao.searchRouteTypeData(keyword);
    }
}
