package ro.ubb.interfaces;

import java.util.List;
import ro.ubb.dtos.ProfileProjectDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.models.ProfileProject;

public interface ProfileProjectService {
    ProfileProjectDto save(ProfileProject profileProject) throws DbException;
    List<Integer> findAllProjectsOfUser(int idProfile) throws DbException;
}
