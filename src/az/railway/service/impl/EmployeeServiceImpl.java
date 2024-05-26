package az.railway.service.impl;

import az.railway.dao.interf.EmployeeDao;
import az.railway.model.Employee;
import az.railway.service.interf.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        return employeeDao.getEmployeeList();
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws Exception {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public void deleteEmployee(long employeeId) throws Exception {
        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
        employeeDao.updateEmployee(employee);
    }
}
