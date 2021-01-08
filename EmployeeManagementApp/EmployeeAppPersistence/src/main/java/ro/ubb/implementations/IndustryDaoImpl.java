package ro.ubb.implementations;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.IndustryDao;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IndustryDaoImpl implements IndustryDao {

    @Override
    public List<String> getAllIndustryNames() throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            List<String> industryNames = new ArrayList<>();

            Statement statement = connection.createStatement();

            String sql = "SELECT Name FROM industry";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String industryName = resultSet.getString("Name");

                industryNames.add(industryName);
            }
            resultSet.close();

            return industryNames;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }
}
