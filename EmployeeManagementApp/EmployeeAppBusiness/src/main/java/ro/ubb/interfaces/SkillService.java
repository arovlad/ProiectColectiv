package ro.ubb.interfaces;

import ro.ubb.dtos.SkillDto;
import ro.ubb.exceptions.DbException;

import java.util.List;

public interface SkillService {

    List<String> getAllTechnologyAreas();

    SkillDto save(Object entity) throws DbException;

    int findByName(String name) throws DbException;

}
