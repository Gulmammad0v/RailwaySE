package az.railway.dao.interf;

import az.railway.model.RouteClass;

import java.util.List;

public interface RouteClassDao {
    List<RouteClass> getRouteClassList() throws Exception;

    void addRouteClass(RouteClass routeClass) throws Exception;

    RouteClass routeClassById(Long routeClassId) throws Exception;
}
