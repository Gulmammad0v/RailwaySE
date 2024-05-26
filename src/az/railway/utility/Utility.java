package az.railway.utility;

import az.railway.dao.impl.*;
import az.railway.dao.interf.*;
import az.railway.model.*;
import az.railway.service.impl.*;
import az.railway.service.interf.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utility {
    public static Customer logIn(String username, String password) throws Exception {
        CustomerDao customerDao = new CustomerDaoImpl();
        CustomerService customerService = new CustomerServiceImpl(customerDao);
        List<Customer> customerList = customerService.getCustomerList();
        for (Customer customer : customerList) {
            if (customer.getUserName().equals(username) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    public static UserRole logInUser(String username, String password) throws Exception {
        UserRoleDao userRoleDao = new UserRoleDaoImpl();
        UserRoleService userRoleService = new UserRoleServiceImpl(userRoleDao);
        List<UserRole> userRoleList = userRoleService.getUserRoleList();
        for (UserRole userRole : userRoleList) {
            if (userRole.getUser().getUserName().equals(username) && userRole.getUser().getPassword().equals(password)) {
                return userRole;
            }
        }
        return null;
    }

    public static String choiceRoute(Long beginStationId, Long endStationId) throws Exception {
        StationDao stationDao = new StationDaoImpl();
        StationService stationService = new StationServiceImpl(stationDao);
        Station begin = stationService.getStationById(beginStationId);
        String beginStation = begin.getStationName();
        Station end = stationService.getStationById(endStationId);
        String endStation = end.getStationName();
        String routeName = beginStation + "-" + endStation;
        Boolean isCheck = checkRoute(routeName);
        if (isCheck) {
            return routeName;
        }
        return null;
    }

    public static boolean checkRoute(String routeName) throws Exception {
        RouteDao routeDao = new RouteDaoImpl();
        RouteService routeService = new RouteServiceImpl(routeDao);
        List<Route> routeList = routeService.getRouteList();
        for (Route route : routeList) {
            String routeName1 = route.getBeginStation().getStationName() + "-" + route.getEndStation().getStationName();
            if (routeName.equals(routeName1)) {
                return true;
            }
        }
        return false;
    }

    public static List<RouteClass> choiceClassOfRoute(String routeName) throws Exception {
        RouteClassDao routeClassDao = new RouteClassDaoImpl();
        RouteClassService routeClassService = new RouteClassServiceImpl(routeClassDao);
        List<RouteClass> routeClassList = routeClassService.getRouteClassList();
        List<RouteClass> routeClassLists = new ArrayList<>();
        RouteClass route = new RouteClass();
        for (RouteClass routeClass : routeClassList) {
            String routeClassName = routeClass.getBeginStation().getStationName() + "-" + routeClass.getEndStation().getStationName();
            if (routeName.equals(routeClassName)) {
                route.setId(routeClass.getId());
                route.setBeginStation(routeClass.getBeginStation());
                route.setEndStation(routeClass.getEndStation());
                route.setaClass(routeClass.getaClass());
                route.setRoutePrice(routeClass.getRoutePrice());
                routeClassLists.add(routeClass);
            }
        }
        return routeClassLists;
    }

    public static List<TrainTimeStation> choiceTimeOfRoute(RouteClass routeClassName) throws Exception {
        TrainTimeStationDao trainTimeStationDao = new TrainTimeStationDaoImpl();
        TrainTimeStationService trainTimeStationService = new TrainTimeStationServiceImpl(trainTimeStationDao);
        List<TrainTimeStation> trainTimeStationList = trainTimeStationService.getTrainTimeStationList();
        List<TrainTimeStation> trainTimeStationLists = new ArrayList<>();
        String trainDirection = routeClassName.getDirection().getDirectionName();
        String beginStation = routeClassName.getBeginStation().getStationName();
        String endStation = routeClassName.getEndStation().getStationName();
        for (TrainTimeStation trainTimeStation : trainTimeStationList) {
            if (trainTimeStation.getTrain().getDirection().getDirectionName().equals(trainDirection)) {
                if (trainTimeStation.getStation().getStationName().equals(beginStation) || trainTimeStation.getStation().getStationName().equals(endStation)) {
                    TrainTimeStation trainTimeStations = new TrainTimeStation();
                    trainTimeStations.setId(trainTimeStation.getId());
                    trainTimeStations.setTrain(trainTimeStation.getTrain());
                    trainTimeStations.setStation(trainTimeStation.getStation());
                    trainTimeStations.setTime(trainTimeStation.getTime());
                    trainTimeStationLists.add(trainTimeStations);
                }
            }
        }
        return trainTimeStationLists;
    }

    public static List<TrainTimeStation> selectTimeOfRoute(List<TrainTimeStation> trainTimeStationList, int trainNumber) throws Exception {
        List<TrainTimeStation> trainTimeStationList1 = new ArrayList<>();
        for (TrainTimeStation trainTimeStation : trainTimeStationList) {
            if (trainNumber == trainTimeStation.getTrain().getTrainNumber()) {
                TrainTimeStation trainTimeStation1 = new TrainTimeStation();
                trainTimeStation1.setId(trainTimeStation.getId());
                trainTimeStation1.setTrain(trainTimeStation.getTrain());
                trainTimeStation1.setStation(trainTimeStation.getStation());
                trainTimeStation1.setTime(trainTimeStation.getTime());
                trainTimeStationList1.add(trainTimeStation1);
            }
        }
        return trainTimeStationList1;
    }

    public static List<Wagon> selectWagonOfRoute(RouteClass routeClassName) throws Exception {
        WagonDao wagonDao = new WagonDaoImpl();
        WagonService wagonService = new WagonServiceImpl(wagonDao);
        List<Wagon> wagonList = wagonService.getWagonList();
        List<Wagon> wagonList1 = new ArrayList<>();
        for (Wagon wagon : wagonList) {
            if (wagon.getaClass().getClassName().equals(routeClassName.getaClass().getClassName())) {
                Wagon selectWagon = new Wagon();
                selectWagon.setId(wagon.getId());
                selectWagon.setWagonName(wagon.getWagonName());
                wagonList1.add(selectWagon);
            }
        }
        return wagonList1;
    }

    public static List<Row> selectRowOfWagon(Wagon wagon) throws Exception {
        RowDao rowDao = new RowDaoImpl();
        RowService rowService = new RowServiceImpl(rowDao);
        List<Row> rowList = rowService.getRowList();
        List<Row> rowList1 = new ArrayList<>();
        for (Row row : rowList) {
            if (row.getWagon().getWagonName().equals(wagon.getWagonName())) {
                Row selectRow = new Row();
                selectRow.setId(row.getId());
                selectRow.setRowName(row.getRowName());
                rowList1.add(selectRow);
            }
        }
        return rowList1;
    }

    public static List<Place> selectPlaceOfRow(Row row) throws Exception {
        PlaceDao placeDao = new PlaceDaoImpl();
        PlaceService placeService = new PlaceServiceImpl(placeDao);
        List<Place> placeList = placeService.getPlaceList();
        List<Place> placeList1 = new ArrayList<>();
        for (Place place : placeList) {
            if (place.getRow().getRowName().equals(row.getRowName())) {
                Place selectPlace = new Place();
                selectPlace.setId(place.getId());
                selectPlace.setPlaceName(place.getPlaceName());
                placeList1.add(selectPlace);
            }
        }
        return placeList1;
    }

    public static boolean checkWagonId(List<Wagon> wagonList, Long wagonId) throws Exception {
        for (Wagon wagon : wagonList) {
            if (wagonId == wagon.getId()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRowId(List<Row> rowList, Long rowId) throws Exception {
        for (Row row : rowList) {
            if (rowId == row.getId()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPlaceId(List<Place> placeList, Long placeId) throws Exception {
        for (Place place : placeList) {
            if (placeId == place.getId()) {
                return true;
            }
        }
        return false;
    }

    public static long setRandomQr() throws Exception {
        TicketDao ticketDao = new TicketDaoImpl();
        TicketService ticketService = new TicketServiceImpl(ticketDao);
        Random random = new Random();
        long randomQr = random.nextLong(1, 1999999999);
        List<Ticket> ticketList = ticketService.getTicketList();
        for (Ticket ticket1 : ticketList) {
            if (randomQr == ticket1.getQr()) {
                setRandomQr();
            }
        }
        return randomQr;
    }
}
