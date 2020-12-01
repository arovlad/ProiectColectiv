package ro.ubb.services;

import ro.ubb.dtos.ProfileSkillDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.ProfileSkillsDaoImpl;
import ro.ubb.interfaces.ProfileSkillsService;
import ro.ubb.mappers.ProfileSkillsDtoMapper;

public class ProfileSkillsServiceImpl implements ProfileSkillsService {

    @Override
    public ProfileSkillDto save(Object entity) throws DbException {
        return ProfileSkillsDtoMapper.mapProfileSkillsToProfileSkillsDto(new ProfileSkillsDaoImpl().save(entity));
    }
}