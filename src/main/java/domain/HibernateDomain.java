package domain;

import businesslogic.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class HibernateDomain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCountry("Marvel");
        address.setCity("New York");
        address.setStreet("Quinse 3");
        address.setPostCode("098724");


        Employee employee = new Employee();
        employee.setFirstName("Piter");
        employee.setLastName("Parker");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1985, Calendar.APRIL, 8);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddressID(address);

        Project project = new Project();
        project.setTitle("Spider Man Return!");

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        session.save(address);
        session.save(employee);
        session.save(project);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
