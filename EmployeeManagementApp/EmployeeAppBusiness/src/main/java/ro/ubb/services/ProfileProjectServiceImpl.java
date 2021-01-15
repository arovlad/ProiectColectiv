package ro.ubb.services;

import java.util.List;
import ro.ubb.dtos.ProfileProjectDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.ProfileProjectDaoImpl;
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

    @Override
    public int delete(int idProfileProject) throws DbException {
        ProfileProject profileProject = new ProfileProjectDaoImpl().delete(idProfileProject);
        if(profileProject != null)
            return 1;
        else
            return 0;
    }

    @Override
    public List<Integer> findAllProjectsOfUser(int idProfile) throws DbException {
        ProfileProjectDaoImpl profileProjectDao = new ProfileProjectDaoImpl();
        return profileProjectDao.findAllProjectsOfUser(idProfile);
    }
}
