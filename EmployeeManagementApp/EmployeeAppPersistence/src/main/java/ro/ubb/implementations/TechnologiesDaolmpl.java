package ro.ubb.implementations;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.TechnologiesDao;
import ro.ubb.models.Region;
import ro.ubb.models.Technologies;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TechnologiesDaoImpl implements GenericDao, TechnologiesDao {
    @Override
    public Technologies find(int id) throws DbException {
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

            int skillID;
            String skillName;
            String technologyAreaName;
            Technologies technologies = null;

            if (resultSet.next()) {
                skillID = resultSet.getInt("ID");
                skillName = resultSet.getString("Skill_Name");

                technologyAreaName = resultSet.getString("Technologies_Area");
                Technologies[] technologies = Technologies.values();
                for (Technologies area : technologies) {
                    if (area.getTechnologies().equals(technologiesName)) {
                        technologies = area;
                    }
                }
            } else
                return null;

            Skill skill = new Skill();
            skill.setId(skillID);
            skill.setSkillName(skillName);
            skill.setTechnologies(technologies);

            return skill;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }
    
    @Override
    public Technologies save(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            Technologies technologies = (Technologies) entity;

            String queryInsert = "INSERT INTO technology(Name) VALUES (?); ";
            PreparedStatement statement = connection.prepareStatement(queryInsert);
            statement.setString(1, technologies.getTechName());
            int result = statement.executeUpdate();

            if (result == 1)
                return technologies;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Technologies delete(int id) throws DbException {
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
            Technologies technologies = (Technologies) find(id);
            int result = preparedStatement.executeUpdate();

            if (result == 1)
                return technologies;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Technologies update(Object entity) throws DbException {
        return null;
    }
}
