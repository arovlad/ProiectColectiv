package ro.ubb.services;

import ro.ubb.dtos.SkillDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.SkillDaoImpl;
import ro.ubb.interfaces.SkillService;
import ro.ubb.mappers.SkillDtoMapper;

import java.util.List;

public class SkillServiceImpl implements SkillService {

    @Override
    public List<String> getAllTechnologyAreas() {
        return new SkillDaoImpl().getAllTechnologyAreas();
    }

    @Override
    public SkillDto save(Object entity) throws DbException {
        return SkillDtoMapper.mapSkillToSkillDto(new SkillDaoImpl().save(entity));
    }
}