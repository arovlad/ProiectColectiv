package ro.ubb.implementations;

import ro.ubb.constants.TechnologyArea;
import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.TechnologiesDao;
import ro.ubb.models.Technologies;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TechnologiesDaoImpl implements GenericDao, TechnologiesDao {
    @Override
    public List<String> findAll() throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT Technologies_Area FROM skills " ;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querySelect);


            String technologyAreaName;

            List<String> names=new ArrayList<>();

            if (resultSet.next()) {

                technologyAreaName = resultSet.getString("Technologies_Area");
                TechnologyArea[] technologyAreas = TechnologyArea.values();
                for (TechnologyArea area : technologyAreas) {
                    if (area.getTechnologyArea().equals(technologyAreaName)) {
                        names.add(area.name());
                    }
                }
            } else
                return null;

            return names;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Object find(int id) throws DbException {
        return null;
    }

    @Override
    public Object save(Object entity) throws DbException {
        return null;
    }

    @Override
    public Object delete(int id) throws DbException {
        return null;
    }


    @Override
    public Technologies update(Object entity) throws DbException {
        return null;
    }
}
