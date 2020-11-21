package ro.ubb.implementations;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.ProjectDao;
import ro.ubb.models.Project;

import ro.ubb.utilities.DatabaseConnection;

import java.sql.*;

public class ProjectDaoImpl implements GenericDao, ProjectDao {

    @Override
    public Project find(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT * FROM Project WHERE ID = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querySelect);
            int idProject, idCustomer, idIndustry,duration;
            String name, description;

            if (resultSet.next()) {
                idProject = resultSet.getInt("ID");
                name = resultSet.getString("Project_Name");
                idCustomer = resultSet.getInt("ID_Customer");
                duration = resultSet.getInt("Duration");
                description = resultSet.getString("Description");
                idIndustry = resultSet.getInt("ID_Industry");
            } else
                return null;

            return new Project(idProject, name, idCustomer, duration, description,
                    idIndustry);
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Project save(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            Project project = (Project) entity;
        if(project.getId_customer()!= 0) {
            System.out.println("hello");
            String queryInsert = "INSERT INTO project ( Project_Name ,ID_Customer,Duration,Description,ID_Industry) VALUES (?,?,?,?,?); ";
            PreparedStatement statement = connection.prepareStatement(queryInsert);
            statement.setString(1, project.getName());
            statement.setInt(2, project.getId_customer());
            statement.setInt(3, project.getDuration());
            statement.setString(4, project.getDescription());
            statement.setInt(5, project.getId_industry());
            int result = statement.executeUpdate();

            if (result == 1)
                return project;
            else
                return null;
        }
        else{
            String queryInsert = "INSERT INTO project ( Project_Name ,ID_Customer,Duration,Description,ID_Industry) VALUES (?,null ,?,?,?); ";
            PreparedStatement statement = connection.prepareStatement(queryInsert);
            statement.setString(1, project.getName());

            statement.setInt(2, project.getDuration());
            statement.setString(3, project.getDescription());
            statement.setInt(4, project.getId_industry());
            int result = statement.executeUpdate();

            if (result == 1)
                return project;
            else
                return null;

        }
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Project delete(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String queryDelete = "DELETE FROM Project WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, id);
            Project project = find(id);
            int result = preparedStatement.executeUpdate();

            if (result == 1)
                return project;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Project update(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            Project project = (Project) entity;
            if(project.getId_customer()!= 0) {
                String queryUpdate = "UPDATE Project SET Project_Name = ?, Id_Customer = ?, Duration = ?, Description = ?, Id_Industry = ? WHERE ID = ?";
                PreparedStatement statement = connection.prepareStatement(queryUpdate);
                statement.setString(1, project.getName());
                statement.setInt(2, project.getId_customer());
                statement.setInt(3, project.getDuration());
                statement.setString(4, project.getDescription());
                statement.setInt(5, project.getId_industry());
                statement.setInt(6, project.getId());
                int result = statement.executeUpdate();

                if (result == 1)
                    return project;
                else
                    return null;
            }
            else{
                String queryUpdate = "UPDATE Project SET Project_Name = ?, Id_Customer = null, Duration = ?, Description = ?, Id_Industry = ? WHERE ID = ?";
                PreparedStatement statement = connection.prepareStatement(queryUpdate);
                statement.setString(1, project.getName());

                statement.setInt(2, project.getDuration());
                statement.setString(3, project.getDescription());
                statement.setInt(4, project.getId_industry());
                statement.setInt(5, project.getId());
                int result = statement.executeUpdate();

                if (result == 1)
                    return project;
                else
                    return null;
            }
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }
}
