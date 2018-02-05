package domain;

import entity.Address;
import entity.Employee;
import entity.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.AddressRepository;
import repository.EmployeeRepository;
import repository.ProjectRepository;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpringDomain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        ProjectRepository projectRepository = context.getBean(ProjectRepository.class);

        Address address = new Address();
        address.setAddressID(16);
        address.setCountry("DC");
        address.setCity("Metropolis");
        address.setStreet("Metro street");
        address.setPostCode("453176");

        Project project = new Project();
        project.setProjectID(6);
        project.setTitle("Dayly Planet in work.");

        Employee employee = new Employee();
        employee.setEmployeeID(6);
        employee.setFirstName("Klark");
        employee.setLastName("Kent");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1986, Calendar.SEPTEMBER, 14);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddressID(address);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        addressRepository.save(address);
        employeeRepository.save(employee);
        projectRepository.save(project);

        System.out.println("\n***********************");
        System.out.println("find all");
        List<Employee> employeeList = employeeRepository.findAll();

        for (Employee empl: employeeList) {
            System.out.println(empl);
        }

        System.out.println("\n***********************");
        System.out.println("find one by id");
        Employee empl = employeeRepository.findOne(3);
        System.out.println(empl);

        System.out.println("\n***********************");
        System.out.println("find by first and last name");
        System.out.println(employeeRepository.findByFirstNameAndLastName("James", "Gordon"));

        System.out.println("\n***********************");
        System.out.println("find by last name");
        System.out.println(employeeRepository.findByLastName("Kent"));
    }
}
