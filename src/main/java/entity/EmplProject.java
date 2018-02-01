package entity;

public class EmplProject {
    private int employeeID;
    private int projectID;

    public EmplProject() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplProject that = (EmplProject) o;

        if (employeeID != that.employeeID) return false;
        return projectID == that.projectID;
    }

    @Override
    public int hashCode() {
        int result = employeeID;
        result = 31 * result + projectID;
        return result;
    }

    @Override
    public String toString() {
        return "EmplProject{" +
                "employeeID=" + employeeID +
                ", projectID=" + projectID +
                '}';
    }
}
