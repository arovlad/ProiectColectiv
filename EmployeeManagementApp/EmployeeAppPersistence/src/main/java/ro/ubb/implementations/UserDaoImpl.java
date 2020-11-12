package ro.ubb.implementations;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.UserDao;
import ro.ubb.models.User;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.*;

public class UserDaoImpl implements GenericDao, UserDao {

    @Override
    public User find(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        String querySelect = "SELECT * FROM userlogin WHERE ID = " + id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(querySelect);
        int id_user, id_role_user, failed_attempts_user;
        String username_user, email_user, password_user;

        if (resultSet.next()) {
            id_user = resultSet.getInt("ID");
            username_user = resultSet.getString("Username");
            email_user = resultSet.getString("Email");
            password_user = resultSet.getString("Password");
            id_role_user = resultSet.getInt("ID_Role");
            failed_attempts_user = resultSet.getInt("Failed_Attempts");
        } else
            return null;

        return new User(id_user, username_user, email_user, password_user, id_role_user, failed_attempts_user);
    }

    @Override
    public User save(Object entity) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        User user = (User) entity;

        String queryInsert = "INSERT INTO userlogin(username,email,password,id_role) VALUES (?,?,?,?); ";
        PreparedStatement statement = connection.prepareStatement(queryInsert);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setInt(4, user.getId_role());
        int result = statement.executeUpdate();

        if (result == 1)
            return user;
        else
            return null;
    }

    @Override
    public User delete(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        String queryDelete = "DELETE FROM userlogin WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
        preparedStatement.setInt(1, id);
        User user = find(id);
        int result = preparedStatement.executeUpdate();

        if (result == 1)
            return user;
        else
            return null;
    }

    @Override
    public User update(Object entity) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        User user = (User) entity;

        String queryUpdate = "UPDATE userlogin SET username = ?, email = ?, password = ?, id_role = ?, failed_attempts = ? WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(queryUpdate);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setInt(4, user.getId_role());
        statement.setInt(5, user.getFailed_attempts());
        statement.setInt(6, user.getId());
        int result = statement.executeUpdate();

        if (result == 1)
            return user;
        else
            return null;
    }

    @Override
    public User findByUsername(String username) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT * FROM userlogin WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(querySelect);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            int id_user, id_role_user, failed_attempts_user;
            String username_user, email_user, password_user;

            if (result.next()) {
                id_user = result.getInt("ID");
                username_user = result.getString("Username");
                email_user = result.getString("Email");
                password_user = result.getString("Password");
                id_role_user = result.getInt("ID_Role");
                failed_attempts_user = result.getInt("Failed_Attempts");
            } else
                return null;

            return new User(id_user, username_user, email_user, password_user, id_role_user,
                    failed_attempts_user);
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }

    }

    @Override
    public User findByEmail(String email) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT * FROM userlogin WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(querySelect);
            statement.setString(1, email);
            ResultSet result = statement.executeQuery();
            int id_user, id_role_user, failed_attempts_user;
            String username_user, email_user, password_user;

            if (result.next()) {
                id_user = result.getInt("ID");
                username_user = result.getString("Username");
                email_user = result.getString("Email");
                password_user = result.getString("Password");
                id_role_user = result.getInt("ID_Role");
                failed_attempts_user = result.getInt("Failed_Attempts");
            } else
                return null;

            return new User(id_user, username_user, email_user, password_user, id_role_user,
                    failed_attempts_user);
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public boolean isLocked(String usernameOrEmail) throws DbException {
        User user = findByUsername(usernameOrEmail);
        if (user != null) {
            return user.getFailed_attempts() > 0;
        } else {
            user = findByEmail(usernameOrEmail);
            if (user != null)
                return user.getFailed_attempts() > 0;
            else
                return false;
        }
    }
}