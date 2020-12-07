package ro.ubb.interfaces;

import ro.ubb.dtos.ProfileSkillDto;
import ro.ubb.exceptions.DbException;

public interface ProfileSkillsService {

    ProfileSkillDto save(Object entity) throws DbException;
}