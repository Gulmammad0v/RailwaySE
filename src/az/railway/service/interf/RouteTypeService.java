package az.railway.service.interf;

import az.railway.model.RouteType;

import java.util.List;

public interface RouteTypeService {
    List<RouteType> getRouteTypeList() throws Exception;

    void addRouteType(RouteType routeType) throws Exception;
    RouteType getRouteTypeById(Long routeTypeId) throws Exception;

    void updateRouteType(RouteType routeType) throws Exception;

    void deleteRouteType(Long routeTypeId) throws Exception;

    List<RouteType> searchRouteTypeData(String keyword) throws Exception;
}
