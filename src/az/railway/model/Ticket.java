package az.railway.model;

public class Ticket extends Railway {
    private Long Qr;
    private Customer customer;
    private RouteClass routeClass;
    private Place place;
    private String time;

    public Long getQr() {
        return Qr;
    }

    public void setQr(Long qr) {
        Qr = qr;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public RouteClass getRouteClass() {
        return routeClass;
    }

    public void setRouteClass(RouteClass routeClass) {
        this.routeClass = routeClass;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return getId() + "." + getRouteClass().getBeginStation().getStationName() + " - " + getRouteClass().getEndStation().getStationName() + " -- " + getRouteClass().getaClass().getClassName() + " -- " + getPlace().getPlaceName() + " -- " + getTime() + " -- " + getRouteClass().getRoutePrice();
    }
}
