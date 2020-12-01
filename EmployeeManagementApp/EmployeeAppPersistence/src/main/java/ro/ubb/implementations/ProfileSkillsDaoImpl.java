package ro.ubb.implementations;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.ProfileSkillsDao;
import ro.ubb.models.Profile;
import ro.ubb.models.ProfileSkills;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.*;

public class ProfileSkillsDaoImpl implements GenericDao, ProfileSkillsDao {
    @Override
    public ProfileSkills find(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT * FROM profile_skills WHERE ID = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querySelect);
            int id_ps, id_profile, id_skill, skill_knowledge_level;

            if (resultSet.next()) {
                id_ps = resultSet.getInt("ID");
                id_profile = resultSet.getInt("ID_Profile");
                id_skill = resultSet.getInt("ID_Skill");
                skill_knowledge_level = resultSet.getInt("Skill_Knowledge_Level");
            } else
                return null;

            return new ProfileSkills(id_ps, id_profile, id_skill, skill_knowledge_level);
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public ProfileSkills save(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            ProfileSkills profileSkills = (ProfileSkills) entity;

            String queryInsert = "INSERT INTO profile_skills(ID_Profile,ID_Skill,Skill_Knowledge_Level) VALUES (?,?,?); ";
            PreparedStatement statement = connection.prepareStatement(queryInsert);
            statement.setInt(1, profileSkills.getId_profile());
            statement.setInt(2, profileSkills.getId_skill());
            statement.setInt(3, profileSkills.getSkill_knowledge_level());
            int result = statement.executeUpdate();

            if (result == 1)
                return profileSkills;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public ProfileSkills delete(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String queryDelete = "DELETE FROM profile_skills WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, id);
            ProfileSkills profileSkills = find(id);
            int result = preparedStatement.executeUpdate();

            if (result == 1)
                return profileSkills;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public ProfileSkills update(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            ProfileSkills profileSkills = (ProfileSkills) entity;

            String queryUpdate = "UPDATE profile_skills SET ID_Profile = ?, ID_Skill = ?, Skill_Knowledge_Level = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(queryUpdate);
            statement.setInt(1, profileSkills.getId_profile());
            statement.setInt(2, profileSkills.getId_skill());
            statement.setInt(3, profileSkills.getSkill_knowledge_level());
            statement.setInt(4, profileSkills.getId());
            int result = statement.executeUpdate();

            if (result == 1)
                return profileSkills;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }
}
