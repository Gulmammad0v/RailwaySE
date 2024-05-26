package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.EmployeeDao;
import az.railway.model.Employee;
import az.railway.model.Position;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;
import az.railway.sql.UpdateConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> getEmployeeList() throws Exception {
        List<Employee> listEmployee = new ArrayList<>();
        String sql = SelectConstant.GET_EMPLOYEE_LIST;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getLong("employee_id"));
                employee.setName(rs.getString("employee_name"));
                employee.setSurname(rs.getString("employee_surname"));
                employee.setDob(rs.getDate("employee_dob"));
                employee.setPin(rs.getString("employee_pin"));
                employee.setPhone(rs.getString("employee_phone"));
                employee.setAddress(rs.getString("employee_address"));
                Position position = new Position();
                employee.setPosition(position);
                position.setPositionName(rs.getString("position_name"));
                listEmployee.add(employee);
            }
        }
        return listEmployee;
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        String sql = InsertConstant.INSERT_EMPLOYEE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setDate(3, new java.sql.Date(employee.getDob().getTime()));
            ps.setString(4, employee.getPin());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getAddress());
            ps.setLong(7, employee.getPosition().getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Employee getEmployeeById(long employeeId) throws Exception {
        String sql = SelectConstant.GET_EMPLOYEE_BY_ID;
        Employee employee = new Employee();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, employeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employee.setId(rs.getLong("employee_id"));
                employee.setName(rs.getString("employee_name"));
                employee.setSurname(rs.getString("employee_surname"));
                employee.setDob(rs.getDate("employee_dob"));
                employee.setPin(rs.getString("employee_pin"));
                employee.setPhone(rs.getString("employee_phone"));
                employee.setAddress(rs.getString("employee_address"));
                Position position = new Position();
                employee.setPosition(position);
                position.setPositionName(rs.getString("position_name"));
            }
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
        String sql = UpdateConstant.UPDATE_EMPLOYEE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setDate(3, new java.sql.Date(employee.getDob().getTime()));
            ps.setString(4, employee.getPin());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getAddress());
            ps.setLong(7, employee.getPosition().getId());
            ps.setLong(8, employee.getId());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public void deleteEmployee(long employeeId) throws Exception {
        String sql = UpdateConstant.DELETE_EMPLOYEE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, employeeId);
            ps.execute();
            c.commit();
        }
    }
}
