import dao.EmployeeDAO;
import dao.impls.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee("Имя", "Фамилия", "female", 30, 1);
        System.out.println("Добавляем нового сотрудника Имя Фамилия - " + employeeDAO.addEmployee(employee));

        System.out.println(employeeDAO.getEmployeeById(34));

        //выводим весь список сотрудников
        System.out.println("выводим весь список сотрудников:\n");
        employeeDAO.getAllEmployee().stream().forEach(System.out::println);

        //изменяем одного сотрудника по id = 1
        employeeDAO.setEmployee(1, employee);

        //удаляем сотрудника по id
        employeeDAO.deleteEmployeeById(34);
    }
}
