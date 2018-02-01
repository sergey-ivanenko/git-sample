package service;

import businesslogic.Util;
import dao.EmployeeDAO;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends Util implements EmployeeDAO{

    //private Connection connection = getConnection();

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO employee (employee_id, first_name, last_name, birthday, address_id) VALUES (?, ?, ?, ?, ?)";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, employee.getEmployeeID());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, employee.getBirthday());
            preparedStatement.setInt(5, employee.getAddressID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT employee_id, first_name, last_name, birthday, address_id FROM employee";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddressID(resultSet.getInt("address_id"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int employeeID) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT employee_id, first_name, last_name, birthday, address_id FROM employee WHERE employee_id=?";

        Employee employee = new Employee();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeID);

            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setEmployeeID(resultSet.getInt("employee_id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setAddressID(resultSet.getInt("address_id"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE employee SET first_name=?, last_name=?, birthday=?, address_id=? WHERE employee_id=?";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setDate(3,employee.getBirthday());
            preparedStatement.setInt(4,employee.getAddressID());
            preparedStatement.setInt(5, employee.getEmployeeID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void removeEmployee(Employee employee) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM employee WHERE employee_id=?";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getEmployeeID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
