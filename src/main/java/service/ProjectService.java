package service;

import businesslogic.SessionUtil;
import dao.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDAO {

    @Override
    public void addProject(Project project) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.save(project);

        // close session with transaction
        closeTransactionSession();

    }

    @Override
    public List<Project> getAllProjects() throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM project";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projectList = query.list();

        // close session with transaction
        closeTransactionSession();

        return projectList;
    }

    @Override
    public Project getProjectById(int projectID) throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM project WHERE projectID = :projectId";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("projectId", projectID);

        Project project = (Project)query.getSingleResult();

        // close session with transaction
        closeTransactionSession();

        return project;
    }

    @Override
    public void updateProject(Project project) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.update(project);

        // close session with transaction
        closeTransactionSession();
    }

    @Override
    public void removeProject(Project project) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(project);

        // close session with transaction
        closeTransactionSession();
    }
}
