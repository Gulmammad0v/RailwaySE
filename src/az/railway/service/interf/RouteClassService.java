package az.railway.service.interf;

import az.railway.model.RouteClass;

import java.util.List;

public interface RouteClassService {
    List<RouteClass> getRouteClassList() throws Exception;

    void addRouteClass(RouteClass routeClass) throws Exception;

    RouteClass getRouteClassById(Long routeClassId) throws Exception;
}
