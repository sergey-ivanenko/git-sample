package entity;

import java.util.Set;

public class Project {
    private int projectID;
    private String title;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (projectID != project.projectID) return false;
        if (title != null ? !title.equals(project.title) : project.title != null) return false;
        return employees != null ? employees.equals(project.employees) : project.employees == null;
    }

    @Override
    public int hashCode() {
        int result = projectID;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectID +
                ", title='" + title + '\'' +
                '}';
    }
}
