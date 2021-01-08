package ro.ubb.services;

import ro.ubb.dtos.ProjectDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.ProjectDaoImpl;
import ro.ubb.interfaces.ProjectService;
import ro.ubb.mappers.ProjectDtoMapper;
import ro.ubb.models.FilterByTechnologyResponse;
import ro.ubb.models.GetAllProjectsFromUserResponse;
import ro.ubb.models.Project;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    @Override
    public GetAllProjectsFromUserResponse findProjectsByUser(int user) throws DbException {
        ProjectDaoImpl projectDao=new ProjectDaoImpl();

        List<Project> projects=projectDao.findProjectsByUser(user);
        boolean projectsFound=!projects.isEmpty();
        GetAllProjectsFromUserResponse response=new GetAllProjectsFromUserResponse();
        response.setProjectsFound(projectsFound);
        response.setProjectList(projects);

        return response;

    }

    @Override
    public ProjectDto find(int id) throws DbException {
        Project project = new ProjectDaoImpl().find(id);
        if(project != null)
            return ProjectDtoMapper.mapProjectToProjectDto(project);
        else
            return null;
    }

    @Override
    public ProjectDto save(Project project) throws DbException {
        Project p = new ProjectDaoImpl().save(project);
        if(p != null)
            return ProjectDtoMapper.mapProjectToProjectDto(p);
        else
            return null;
    }

    @Override
    public ProjectDto delete(int id) throws DbException {
        Project p = new ProjectDaoImpl().delete(id);
        if(p != null)
            return ProjectDtoMapper.mapProjectToProjectDto(p);
        else
            return null;
    }

    @Override
    public ProjectDto update(Project project) throws DbException {
        Project p = new ProjectDaoImpl().update(project);
        if(p != null)
            return ProjectDtoMapper.mapProjectToProjectDto(p);
        else
            return null;
    }
}
