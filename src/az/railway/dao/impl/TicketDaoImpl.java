package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.TicketDao;
import az.railway.model.*;
import az.railway.model.Class;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao {
    @Override
    public List<Ticket> getTicketList() throws Exception {
        String sql = SelectConstant.GET_TICKET_LIST;
        List<Ticket> listTicket = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Ticket ticket = new Ticket();
                RouteClass routeClass = new RouteClass();
                Customer customer = new Customer();
                Station beginStation = new Station();
                Station endStation = new Station();
                Place place = new Place();
                Row row = new Row();
                Wagon wagon = new Wagon();
                Class aClass = new Class();
                ticket.setId(rs.getLong("TICKET_ID"));
                ticket.setQr(rs.getLong("TICKET_QR"));
                customer.setName(rs.getString("CUSTOMER_NAME"));
                customer.setSurname(rs.getString("CUSTOMER_SURNAME"));
                beginStation.setStationName(rs.getString("BEGIN_STATION"));
                endStation.setStationName(rs.getString("END_STATION"));
                place.setPlaceName(rs.getString("PLACE_NAME"));
                row.setRowName(rs.getInt("ROW_NAME"));
                wagon.setWagonName(rs.getString("WAGON_NAME"));
                aClass.setClassName(rs.getString("CLASS_NAME"));
                routeClass.setRoutePrice(rs.getFloat("ROUTE_PRICE"));
                ticket.setTime(rs.getString("TIME"));
                routeClass.setaClass(aClass);
                routeClass.setBeginStation(beginStation);
                routeClass.setEndStation(endStation);
                place.setRow(row);
                place.setWagon(wagon);
                ticket.setCustomer(customer);
                ticket.setRouteClass(routeClass);
                ticket.setPlace(place);
                listTicket.add(ticket);
            }
        }
        return listTicket;
    }

    @Override
    public void addTicket(Ticket ticket) throws Exception {
        String sql = InsertConstant.INSERT_TICKET;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, ticket.getQr());
            ps.setLong(2, ticket.getCustomer().getId());
            ps.setFloat(3, ticket.getRouteClass().getId());
            ps.setFloat(4, ticket.getPlace().getId());
            ps.setString(5, ticket.getTime());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Ticket getTicketById(long ticketId) throws Exception {
        String sql = SelectConstant.GET_TICKET_BY_ID;
        Ticket ticket = new Ticket();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, ticketId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RouteClass routeClass = new RouteClass();
                Customer customer = new Customer();
                Station beginStation = new Station();
                Station endStation = new Station();
                Place place = new Place();
                Row row = new Row();
                Wagon wagon = new Wagon();
                Class aClass = new Class();
                ticket.setId(rs.getLong("TICKET_ID"));
                ticket.setQr(rs.getLong("TICKET_QR"));
                customer.setName(rs.getString("CUSTOMER_NAME"));
                customer.setSurname(rs.getString("CUSTOMER_SURNAME"));
                beginStation.setStationName(rs.getString("BEGIN_STATION"));
                endStation.setStationName(rs.getString("END_STATION"));
                place.setPlaceName(rs.getString("PLACE_NAME"));
                row.setRowName(rs.getInt("ROW_NAME"));
                wagon.setWagonName(rs.getString("WAGON_NAME"));
                aClass.setClassName(rs.getString("CLASS_NAME"));
                routeClass.setRoutePrice(rs.getFloat("ROUTE_PRICE"));
                ticket.setTime(rs.getString("TIME"));
                routeClass.setaClass(aClass);
                routeClass.setBeginStation(beginStation);
                routeClass.setEndStation(endStation);
                place.setRow(row);
                place.setWagon(wagon);
                ticket.setCustomer(customer);
                ticket.setRouteClass(routeClass);
                ticket.setPlace(place);
            }
        }
        return ticket;
    }
}
