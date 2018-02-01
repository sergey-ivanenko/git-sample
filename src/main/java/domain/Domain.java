package domain;

import entity.Address;
import entity.EmplProject;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmplProjectService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class Domain {

    public static void main(String[] args) {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmplProjectService emplProjectService = new EmplProjectService();

        Address address = new Address();
        address.setAddressID(1);
        address.setCountry("DC");
        address.setCity("Gotham City");
        address.setStreet("Arkham street 1");
        address.setPostCode("12345");

        Employee employee = new Employee();
        employee.setEmployeeID(1);
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddressID(address.getAddressID());

        Project project = new Project();
        project.setProjectID(1);
        project.setTitle("Gotham City Police Department Commissioner");

        EmplProject emplProject = new EmplProject();
        emplProject.setEmployeeID(employee.getEmployeeID());
        emplProject.setProjectID(project.getProjectID());

        try {
            addressService.addAddress(address);
            employeeService.addEmployee(employee);
            projectService.addProject(project);
            emplProjectService.addEmplProject(emplProject);

            List<Employee> employeeList = employeeService.getAllEmployees();
            for (Employee emp: employeeList) {
                System.out.println(emp);
            }

            List<Address> addressList = addressService.getAllAddresses();
            for (Address a: addressList) {
                System.out.println(a);
            }

            List<Project> projectList = projectService.getAllProjects();
            for (Project p: projectList) {
                System.out.println(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
