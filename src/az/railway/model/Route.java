package az.railway.model;

public class Route extends Railway {
    private Station BeginStation;
    private Station EndStation;
    private RouteType RouteType;
    private Direction direction;

    public Station getBeginStation() {
        return BeginStation;
    }

    public void setBeginStation(Station beginStation) {
        BeginStation = beginStation;
    }

    public Station getEndStation() {
        return EndStation;
    }

    public void setEndStation(Station endStation) {
        EndStation = endStation;
    }

    public RouteType getRouteType() {
        return RouteType;
    }

    public void setRouteType(RouteType routeType) {
        RouteType = routeType;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
