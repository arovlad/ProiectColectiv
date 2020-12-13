package ro.ubb.implementations;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.RegionDao;
import ro.ubb.models.Profile;
import ro.ubb.models.Region;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.*;

public class RegionDaoImpl implements GenericDao, RegionDao {
    @Override
    public Region find(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT * FROM regions WHERE ID = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querySelect);
            int id_region;
            String name;

            if (resultSet.next()) {
                id_region = resultSet.getInt("ID");
                name = resultSet.getString("Name");
            } else
                return null;

            return new Region(id_region, name);
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Region save(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            Region region = (Region) entity;

            String queryInsert = "INSERT INTO regions(Name) VALUES (?); ";
            PreparedStatement statement = connection.prepareStatement(queryInsert);
            statement.setString(1, region.getName());
            int result = statement.executeUpdate();

            if (result == 1)
                return region;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Region delete(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String queryDelete = "DELETE FROM regions WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, id);
            Region region = find(id);
            int result = preparedStatement.executeUpdate();

            if (result == 1)
                return region;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Region update(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            Region region = (Region) entity;

            String queryUpdate = "UPDATE regions SET Name = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(queryUpdate);
            statement.setString(1, region.getName());
            statement.setInt(2, region.getId());
            int result = statement.executeUpdate();

            if (result == 1)
                return region;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }
}
