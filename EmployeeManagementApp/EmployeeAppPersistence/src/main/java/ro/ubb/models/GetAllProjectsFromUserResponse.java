package ro.ubb.models;

import java.util.List;

public class GetAllProjectsFromUserResponse {
    private boolean projectsFound;
    private List<Project> projectList;

    public GetAllProjectsFromUserResponse(){
    }

    public boolean isProjectsFound(){
        return projectsFound;
    }

    public void setProjectsFound(boolean projectsFound){
        this.projectsFound=projectsFound;
    }

    public List<Project> getProjectList(){
        return projectList;
    }
    public void setProjectList(List<Project> projectList){
        this.projectList=projectList;
    }

}
