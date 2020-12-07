package ro.ubb.implementations;

import ro.ubb.constants.TechnologyArea;
import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.GenericDao;
import ro.ubb.interfaces.SkillDao;
import ro.ubb.models.Skill;
import ro.ubb.utilities.DatabaseConnection;

import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkillDaoImpl implements GenericDao, SkillDao {

    @Override
    public Skill find(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT * FROM skills WHERE ID = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querySelect);

            int skillID;
            String skillName;
            String technologyAreaName;
            TechnologyArea technologyArea = null;

            if (resultSet.next()) {
                skillID = resultSet.getInt("ID");
                skillName = resultSet.getString("Skill_Name");

                technologyAreaName = resultSet.getString("Technologies_Area");
                TechnologyArea[] technologyAreas = TechnologyArea.values();
                for (TechnologyArea area : technologyAreas) {
                    if (area.getTechnologyArea().equals(technologyAreaName)) {
                        technologyArea = area;
                    }
                }
            } else
                return null;

            Skill skill = new Skill();
            skill.setId(skillID);
            skill.setSkillName(skillName);
            skill.setTechnologyArea(technologyArea);

            return skill;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Skill save(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            Skill skill = (Skill) entity;

            String queryInsert = "INSERT INTO skills(Skill_Name,Technologies_Area) " +
                    "VALUES (?,?);";
            PreparedStatement statement = connection.prepareStatement(queryInsert);
            statement.setString(1, skill.getSkillName());
            statement.setString(2, skill.getTechnologyArea().getTechnologyArea());
            int result = statement.executeUpdate();

            if (result == 1)
                return skill;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Skill delete(int id) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String queryDelete = "DELETE FROM skills WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setInt(1, id);
            Skill skill = find(id);
            int result = preparedStatement.executeUpdate();

            if (result == 1)
                return skill;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public Skill update(Object entity) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            Skill skill = (Skill) entity;

            String queryUpdate = "UPDATE Skills SET Skill_Name = ?, " +
                    "Technologies_Area = ? WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(queryUpdate);
            statement.setString(1, skill.getSkillName());
            statement.setString(2, skill.getTechnologyArea().getTechnologyArea());
            statement.setInt(3, skill.getId());
            int result = statement.executeUpdate();

            if (result == 1)
                return skill;
            else
                return null;
        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

    @Override
    public List<String> getAllTechnologyAreas() {
        return Stream.of(TechnologyArea
                .values())
                .map(TechnologyArea::getTechnologyArea)
                .collect(Collectors.toList());
    }

    @Override
    public Skill findByName(String name) throws DbException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();

            String querySelect = "SELECT * FROM skills WHERE Skill_Name = ?";
            PreparedStatement statement = connection.prepareStatement(querySelect);
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();

            int skillID;
            String skillName;
            String technologyAreaName;
            TechnologyArea technologyArea = null;

            if (result.next()) {
                skillID = result.getInt("ID");
                skillName = result.getString("Skill_Name");

                technologyAreaName = result.getString("Technologies_Area");
                TechnologyArea[] technologyAreas = TechnologyArea.values();
                for (TechnologyArea area : technologyAreas) {
                    if (area.getTechnologyArea().equals(technologyAreaName)) {
                        technologyArea = area;
                    }
                }
            } else
                return null;

            Skill skill = new Skill();
            skill.setId(skillID);
            skill.setSkillName(skillName);
            skill.setTechnologyArea(technologyArea);

            return skill;

        } catch (SQLException sqlException) {
            throw new DbException("Something went wrong with the database");
        }
    }

}