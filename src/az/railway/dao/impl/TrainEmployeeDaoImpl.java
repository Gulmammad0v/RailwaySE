package az.railway.dao.impl;

import az.railway.dao.DbHelper;
import az.railway.dao.interf.TrainEmployeeDao;
import az.railway.model.*;
import az.railway.sql.InsertConstant;
import az.railway.sql.SelectConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrainEmployeeDaoImpl implements TrainEmployeeDao {
    @Override
    public List<TrainEmployee> getTrainEmployeeList() throws Exception {
        String sql = SelectConstant.GET_TRAIN_EMPLOYEE_LIST;
        List<TrainEmployee> listTrainEmployee = new ArrayList<>();
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                TrainEmployee trainEmployee = new TrainEmployee();
                trainEmployee.setId(rs.getLong("TRAIN_EMPLOYEE_ID"));
                Train train = new Train();
                train.setTrainNumber(rs.getInt("TRAIN_NUMBER"));
                Employee employee = new Employee();
                employee.setName(rs.getString("EMPLOYEE_NAME"));
                employee.setSurname(rs.getString("EMPLOYEE_SURNAME"));
                Position position = new Position();
                position.setPositionName(rs.getString("POSITION_NAME"));
                trainEmployee.setEmployee(employee);
                trainEmployee.setTrain(train);
                trainEmployee.setPosition(position);
                listTrainEmployee.add(trainEmployee);
            }
        }
        return listTrainEmployee;
    }

    @Override
    public void addTrainEmployee(TrainEmployee trainEmployee) throws Exception {
        String sql = InsertConstant.INSERT_TRAIN_EMPLOYEE;
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, trainEmployee.getTrain().getId());
            ps.setLong(2, trainEmployee.getEmployee().getId());
            ps.execute();
            c.commit();
        }
    }
}
