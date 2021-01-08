package ro.ubb.implementations;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.TechnologiesAreasDao;
import ro.ubb.models.Region;
import ro.ubb.models.TechnologiesAreas;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TechnologiesAreasDaoImpl implements GenericDao, TechnologiesAreasDao {
    @Override
    public TechnologiesAreas find(int id) throws DbException {
        return null;
    }

    @Override
    public TechnologiesAreas save(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            TechnologiesAreas technologiesAreas = (TechnologiesAreas) entity;

            String queryInsert = "INSERT INTO technology(Name) VALUES (?); ";
            PreparedStatement statement = connection.prepareStatement(queryInsert);
            statement.setString(1, technologiesAreas.getTechName());
            int result = statement.executeUpdate();

            if (result == 1)
                return technologiesAreas;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public TechnologiesAreas delete(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String queryDelete = "DELETE FROM technology WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, id);
            TechnologiesAreas technologiesAreas = (TechnologiesAreas) find(id);
            int result = preparedStatement.executeUpdate();

            if (result == 1)
                return technologiesAreas;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public TechnologiesAreas update(Object entity) throws DbException {
        return null;
    }
}
