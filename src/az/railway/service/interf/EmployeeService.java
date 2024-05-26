package az.railway.service.interf;

import az.railway.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList() throws Exception;

    void addEmployee(Employee employee) throws Exception;

    Employee getEmployeeById(Long employeeId) throws Exception;
    void updateEmployee(Employee employee) throws Exception;

    void deleteEmployee(long employeeId) throws Exception;
}
