package repository;

import entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employee WHERE first_name=?1 AND last_name=?2", nativeQuery = true)
    Employee findByFirstNameAndLastName(String firstName, String lasrName);

    Employee findByLastName(String lastName);
}
