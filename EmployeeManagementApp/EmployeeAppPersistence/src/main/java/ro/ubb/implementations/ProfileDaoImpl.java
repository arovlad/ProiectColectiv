package ro.ubb.implementations;

import ro.ubb.constants.TechnologyArea;
import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.ProfileDao;
import ro.ubb.models.Profile;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileDaoImpl implements GenericDao, ProfileDao {

    @Override
    public Profile find(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT * FROM profile WHERE ID = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querySelect);
            int id_profile, id_user, id_consulting_level, verified;
            String first_name, last_name, picture;

            if (resultSet.next()) {
                id_profile = resultSet.getInt("ID");
                id_user = resultSet.getInt("ID_User");
                first_name = resultSet.getString("First_Name");
                last_name = resultSet.getString("Last_Name");
                picture = resultSet.getString("Picture");
                id_consulting_level = resultSet.getInt("ID_Consulting_Level");
                verified = resultSet.getInt("Verified");
            } else
                return null;

            return new Profile(id_profile, id_user, first_name,last_name, picture, id_consulting_level, verified);
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }


    @Override
    public Profile save(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            Profile profile = (Profile) entity;

            String queryInsert = "INSERT INTO profile(ID_User,First_Name,Last_Name,Picture, ID_Consulting_Level) VALUES (?,?,?,?,?); ";
            PreparedStatement statement = connection.prepareStatement(queryInsert);
            statement.setInt(1, profile.getId_user());
            statement.setString(2, profile.getFirst_name());
            statement.setString(3, profile.getLast_name());
            statement.setString(4, profile.getPicture());
            statement.setInt(5, profile.getId_consulting_level());
            int result = statement.executeUpdate();

            if (result == 1)
                return profile;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }


    @Override
    public Profile delete(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String queryDelete = "DELETE FROM profile WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, id);
            Profile profile = find(id);
            int result = preparedStatement.executeUpdate();

            if (result == 1)
                return profile;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }


    @Override
    public Profile update(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            Profile profile = (Profile) entity;

            String queryUpdate = "UPDATE profile SET ID_User = ?, First_Name = ?, Last_Name = ?, Picture = ?, ID_Consulting_Level = ?, Verified = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(queryUpdate);
            statement.setInt(1, profile.getId_user());
            statement.setString(2, profile.getFirst_name());
            statement.setString(3, profile.getLast_name());
            statement.setString(4, profile.getPicture());
            statement.setInt(5, profile.getId_consulting_level());
            statement.setInt(6, profile.getVerified());
            statement.setInt(7, profile.getId());
            int result = statement.executeUpdate();

            if (result == 1)
                return profile;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public List<Profile> getAllProfiles(TechnologyArea technologyArea) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            List<Profile> profiles = new ArrayList<Profile>();

            String query = "SELECT p.ID FROM profile p JOIN profile_skills ps ON p.ID = ps.ID_Profile JOIN skills s ON ps.ID_Skill = s.ID WHERE s.Technologies_Area =  ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, technologyArea.getTechnologyArea());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int profileID = resultSet.getInt("ID");
                Profile profile = find(profileID);
                profiles.add(profile);
            }

            return profiles;

        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }
}
