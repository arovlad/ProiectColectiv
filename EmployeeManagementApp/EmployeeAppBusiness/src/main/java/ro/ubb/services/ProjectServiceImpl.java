package ro.ubb.services;

import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.ProjectDaoImpl;
import ro.ubb.interfaces.ProjectService;
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
}
