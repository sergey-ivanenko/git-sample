package entity;

public class Project {
    private int projectID;
    private String title;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (projectID != project.projectID) return false;
        return title != null ? title.equals(project.title) : project.title == null;
    }

    @Override
    public int hashCode() {
        int result = projectID;
        result = 31 * result + (title != null ? title.hashCode() : 0);
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
