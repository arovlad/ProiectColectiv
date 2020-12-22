package ro.ubb.implementations;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.UserRoleDao;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDaoImpl implements UserRoleDao {
    @Override
    public List<String> getAllUserRoleNames() throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            List<String> userRoleNames = new ArrayList<>();

            Statement statement = connection.createStatement();

            String sql = "SELECT Name FROM user_role";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String userRoleName = resultSet.getString("Name");

                userRoleNames.add(userRoleName);
            }
            resultSet.close();

            return userRoleNames;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }
}
