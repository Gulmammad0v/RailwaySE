package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.CustomerDao;
import az.railway.model.Customer;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Customer> getCustomerList() throws Exception {
        String sql = SelectConstant.GET_CUSTOMER_LIST;
        List<Customer> listCustomer = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setDob(rs.getDate("DOB"));
                customer.setPin(rs.getString("PIN"));
                customer.setPhone(rs.getString("PHONE"));
                customer.setEmail(rs.getString("E_MAIL"));
                customer.setUserName(rs.getString("USER_NAME"));
                customer.setPassword(rs.getString("PASSWORD"));
                listCustomer.add(customer);
            }
        }
        return listCustomer;
    }

    @Override
    public void addCustomer(Customer customer) throws Exception {
        String sql = InsertConstant.INSERT_CUSTOMER;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getSurname());
            ps.setDate(3, new java.sql.Date(customer.getDob().getTime()));
            ps.setString(4, customer.getPin());
            ps.setString(5, customer.getPhone());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getUserName());
            ps.setString(8, customer.getPassword());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Customer getCustomerById(Long customerId) throws Exception {
        String sql = SelectConstant.GET_CUSTOMER_BY_ID;
        Customer customer = new Customer();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer.setId(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setDob(rs.getDate("DOB"));
                customer.setPin(rs.getString("PIN"));
                customer.setPhone(rs.getString("PHONE"));
                customer.setEmail(rs.getString("E_MAIL"));
                customer.setUserName(rs.getString("USER_NAME"));
                customer.setPassword(rs.getString("PASSWORD"));
            }
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {
        String sql = UpdateConstant.UPDATE_CUSTOMER;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getSurname());
            ps.setDate(3, new java.sql.Date(customer.getDob().getTime()));
            ps.setString(4, customer.getPin());
            ps.setString(5, customer.getPhone());
            ps.setString(6, customer.getEmail());
            ps.setString(7, customer.getUserName());
            ps.setString(8, customer.getPassword());
            ps.setLong(9, customer.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteCustomer(Long customerId) throws Exception {
        String sql = UpdateConstant.DELETE_CUSTOMER;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, customerId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Customer> searchCustomer(String keyword) throws Exception {
        String sql = SelectConstant.SEARCH_CUSTOMER_DATA;
        List<Customer> listCustomer = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("ID"));
                customer.setName(rs.getString("NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setDob(rs.getDate("DOB"));
                customer.setPin(rs.getString("PIN"));
                customer.setPhone(rs.getString("PHONE"));
                customer.setEmail(rs.getString("E_MAIL"));
                customer.setUserName(rs.getString("USER_NAME"));
                customer.setPassword(rs.getString("PASSWORD"));
                listCustomer.add(customer);
            }
        }
        return listCustomer;
    }
}
