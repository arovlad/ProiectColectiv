package ro.ubb.services;

import ro.ubb.dtos.ProfileProjectDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.ProfileProjectDaoImpl;
import ro.ubb.implementations.ProjectDaoImpl;
import ro.ubb.interfaces.ProfileProjectService;
import ro.ubb.mappers.ProfileProjectDtoMapper;
import ro.ubb.models.ProfileProject;


public class ProfileProjectServiceImpl implements ProfileProjectService {
    @Override
    public ProfileProjectDto save(ProfileProject profileProject) throws DbException {
        ProfileProject p = new ProfileProjectDaoImpl().save(profileProject);
        if(p != null){
            return ProfileProjectDtoMapper.mapProfileProjectToProfileProjectDto(p);
        }
        else {
            return null;
        }
    }
}
