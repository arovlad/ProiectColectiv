package ro.ubb.implementations;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.ProjectDao;
import ro.ubb.models.Project;

import ro.ubb.utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

    @Override
    public List<Project> findProjectsByUser(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            DatabaseConnection databaseConnection=new DatabaseConnection();
            Connection connection=databaseConnection.getConnection();


            List<Project> projects=new ArrayList<>();
            String query="SELECT proj.Project_Name,proj.Description,proj.Duration FROM profile prof join profile_project pp on prof.ID=pp.ID_Profile join project_role pr on pp.ID_Role=pr.ID join project proj on pp.ID_Project=proj.ID join industry i on proj.ID_Industry=i.ID join customer c on proj.ID_Customer=c.ID where prof.ID_User=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();

            String proj_name,description;
            int duration;
            while(resultSet.next()){
                proj_name=resultSet.getString("Project_Name");
                description=resultSet.getString("Description");
                duration=resultSet.getInt("Duration");
                Project project=new Project(proj_name,duration,description);
                projects.add(project);
            }

            return projects;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
