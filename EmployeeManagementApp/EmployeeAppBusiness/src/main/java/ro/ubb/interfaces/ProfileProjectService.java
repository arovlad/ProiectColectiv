package ro.ubb.interfaces;


import ro.ubb.dtos.ProfileProjectDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.models.ProfileProject;

public interface ProfileProjectService {
    ProfileProjectDto save(ProfileProject profileProject) throws DbException;
}
