package az.railway.model;

public class RouteClass extends Railway {
    private Route route;
    private Station beginStation;
    private Station endStation;
    private RouteType routeType;
    private Class aClass;
    private float RoutePrice;
    private Direction direction;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Station getBeginStation() {
        return beginStation;
    }

    public void setBeginStation(Station beginStation) {
        this.beginStation = beginStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public float getRoutePrice() {
        return RoutePrice;
    }

    public void setRoutePrice(float routePrice) {
        RoutePrice = routePrice;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return getId() + "." + getBeginStation().getStationName() + "-" + getEndStation().getStationName() + " -> " + getaClass().getClassName() + " = " + getRoutePrice();
    }
}
