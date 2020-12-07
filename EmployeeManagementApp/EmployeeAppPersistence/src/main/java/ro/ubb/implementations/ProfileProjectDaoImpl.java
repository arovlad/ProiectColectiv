package ro.ubb.implementations;

import ro.ubb.constants.ProjectRole;
import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.ProfileProjectDao;
import ro.ubb.models.ProfileProject;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.*;

public class ProfileProjectDaoImpl implements GenericDao, ProfileProjectDao {
    @Override
    public ProfileProject find(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT * FROM profile_project WHERE ID = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querySelect);
            int profileProjectID, profileID, projectID, roleID;
            boolean finished;
            ProjectRole projectRole = null;

            if (resultSet.next()) {
                profileProjectID = resultSet.getInt("ID");
                profileID = resultSet.getInt("ID_Profile");
                projectID = resultSet.getInt("ID_Project");
                finished = resultSet.getBoolean("Finished");
                roleID = resultSet.getInt("ID_Role");

                ProjectRole[] projectRoles = ProjectRole.values();
                for (ProjectRole pR : projectRoles){
                    if (pR.getId() == roleID) {
                        projectRole = pR;
                    }
                }
            } else
                return null;

            return new ProfileProject(profileProjectID, profileID, projectID, finished, projectRole);

        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public ProfileProject save(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            ProfileProject profileProject = (ProfileProject) entity;

            String queryInsert = "INSERT INTO Profile_Project (ID_Profile, ID_Project, Finished, ID_Role) " +
                    "VALUES (?,?,?,?);";
            PreparedStatement statement = connection.prepareStatement(queryInsert);
            statement.setInt(1, profileProject.getIdProfile());
            statement.setInt(2, profileProject.getIdProject());
            statement.setBoolean(3, profileProject.isFinished());
            statement.setInt(4,profileProject.getProjectRole().getId());
            int result = statement.executeUpdate();

            if (result == 1)
                return profileProject;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public ProfileProject delete(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String queryDelete = "DELETE FROM Profile_Project WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, id);
            ProfileProject profileProject = find(id);
            int result = preparedStatement.executeUpdate();

            if (result == 1)
                return profileProject;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public ProfileProject update(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            ProfileProject profileProject = (ProfileProject) entity;

            String queryUpdate = "UPDATE Profile_Project SET ID_Profile = ?, " +
                    "ID_Project = ?, Finished = ?, ID_Role = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(queryUpdate);
            statement.setInt(1, profileProject.getIdProfile());
            statement.setInt(2, profileProject.getIdProject());
            statement.setBoolean(3, profileProject.isFinished());
            statement.setInt(4, profileProject.getProjectRole().getId());
            statement.setInt(5, profileProject.getId());
            int result = statement.executeUpdate();

            if (result == 1)
                return profileProject;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }
}