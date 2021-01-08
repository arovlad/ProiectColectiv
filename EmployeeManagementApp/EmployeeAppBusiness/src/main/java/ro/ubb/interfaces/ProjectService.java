package ro.ubb.interfaces;

import ro.ubb.dtos.ProjectDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.models.GetAllProjectsFromUserResponse;
import ro.ubb.models.Project;

public interface ProjectService {
    GetAllProjectsFromUserResponse findProjectsByUser(int user) throws DbException;

    ProjectDto find(int id) throws DbException;

    ProjectDto save(Project project) throws DbException;

    ProjectDto delete(int id) throws DbException;

    ProjectDto update(Project project) throws DbException;
}
