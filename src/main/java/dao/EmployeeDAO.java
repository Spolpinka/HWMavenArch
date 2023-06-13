package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    boolean addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    boolean setEmployee(int id, Employee employee);

    boolean deleteEmployeeById(int id);
}
