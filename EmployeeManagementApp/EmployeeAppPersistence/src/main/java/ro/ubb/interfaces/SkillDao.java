package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.Skill;

import java.util.List;

public interface SkillDao {

    List<String> getAllTechnologyAreas();

    public Skill findByName(String name) throws DbException;
}