package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.PaymentDao;
import az.railway.model.*;
import az.railway.model.Class;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {
    @Override
    public List<Payment> getPaymentList() throws Exception {
        String sql = SelectConstant.GET_PAYMENT_LIST;
        List<Payment> listPayment = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Payment payment = new Payment();
                Ticket ticket = new Ticket();
                RouteClass routeClass = new RouteClass();
                Customer customer = new Customer();
                Station beginStation = new Station();
                Station endStation = new Station();
                Place place = new Place();
                Row row = new Row();
                Wagon wagon = new Wagon();
                Class aClass = new Class();
                payment.setId(rs.getLong("PAYMENT_ID"));
                customer.setName(rs.getString("CUSTOMER_NAME"));
                customer.setSurname(rs.getString("CUSTOMER_SURNAME"));
                beginStation.setStationName(rs.getString("BEGIN_STATION"));
                endStation.setStationName(rs.getString("END_STATION"));
                place.setPlaceName(rs.getString("PLACE_NAME"));
                row.setRowName(rs.getInt("ROW_NAME"));
                wagon.setWagonName(rs.getString("WAGON_NAME"));
                aClass.setClassName(rs.getString("CLASS_NAME"));
                routeClass.setRoutePrice(rs.getFloat("ROUTE_PRICE"));
                payment.setTicketCount(rs.getInt("TICKET_COUNT"));
                payment.setAmount(rs.getFloat("AMOUNT"));
                payment.setDataDate(rs.getDate("PAY_DATE"));
                routeClass.setaClass(aClass);
                routeClass.setBeginStation(beginStation);
                routeClass.setEndStation(endStation);
                place.setRow(row);
                place.setWagon(wagon);
                ticket.setCustomer(customer);
                ticket.setRouteClass(routeClass);
                ticket.setPlace(place);
                payment.setTicket(ticket);
                listPayment.add(payment);
            }
            return listPayment;
        }
    }

    @Override
    public void addPayment(Payment payment) throws Exception {
        String sql = InsertConstant.INSERT_PAYMENT;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, payment.getTicketCount());
            ps.setLong(2, payment.getTicket().getId());
            ps.setFloat(3, payment.getAmount());
            ps.execute();
            c.commit();
        }
    }
}
