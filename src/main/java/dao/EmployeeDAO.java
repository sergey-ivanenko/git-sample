package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    // create
    void addEmployee(Employee employee) throws SQLException;

    // read
    List<Employee> getAllEmployees() throws SQLException;

    Employee getEmployeeById(int employeeID) throws SQLException;

    // update
    void updateEmployee(Employee employee) throws SQLException;

    // delete
    void removeEmployee(Employee employee) throws SQLException;
}
