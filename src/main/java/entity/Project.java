package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project implements Serializable{

    private static final long serialVersionUID = 1796556740932985128L;

    @Id
    private int projectID;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee>employees;

    public Project() {
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectID +
                ", title='" + title + '\'' +
                '}';
    }
}
