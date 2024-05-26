package az.railway.dao.interf;

import az.railway.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmployeeList() throws Exception;

    void addEmployee(Employee employee) throws Exception;

    Employee getEmployeeById(long employeeId) throws Exception;

    void updateEmployee(Employee employee) throws Exception;

    void deleteEmployee(long employeeId) throws Exception;
}
