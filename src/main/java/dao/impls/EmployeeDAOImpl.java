package dao.impls;

import dao.EmployeeDAO;
import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public boolean addEmployee(Employee employee) {
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO employee " +
                     "(first_name, last_name, gender, age, city_id) VALUES " +
                     "((?), (?), (?), (?), (?))")){
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getGender());
            ps.setInt(4, employee.getAge());
            ps.setInt(5, employee.getCityId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
            ps.setInt(1, id);
            ps.executeQuery();
            ResultSet resultSet = ps.getResultSet();
            if (resultSet.next()) {
                return new Employee(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getInt("city_id"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> result = new ArrayList<>();
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee ORDER BY id")) {
            ps.execute();
            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                result.add(new Employee(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        resultSet.getInt("city_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean setEmployee(int id, Employee employee) {
        try (Connection connection = JDBCConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE employee " +
                "SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?) " +
                "WHERE id = (?)")) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getGender());
            ps.setInt(4, employee.getAge());
            ps.setInt(5, employee.getCityId());
            ps.setInt(6, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmployeeById (int id){
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM employee WHERE id = (?)")) {
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
