package service;

import businesslogic.SessionUtil;
import dao.EmployeeDAO;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class EmployeeService extends SessionUtil implements EmployeeDAO{

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        // close session with transaction
        closeTransactionSession();
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM employee";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employeeList = query.list();

        // close session with transaction
        closeTransactionSession();

        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int employeeID) throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM employee WHERE employeeID = :employeeId";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("employeeId", employeeID);

        Employee employee = (Employee)query.getSingleResult();

        // close session with transaction
        closeTransactionSession();

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        // close session with transaction
        closeTransactionSession();
    }

    @Override
    public void removeEmployee(Employee employee) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(employee);

        // close session with transaction
        closeTransactionSession();
    }
}
