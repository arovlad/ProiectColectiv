package ro.ubb.models;

import ro.ubb.constants.ProjectRole;

public class ProfileProject {
    private int id;
    private int idProfile;
    private int idProject;
    private boolean finished;
    private ProjectRole projectRole;

    ProfileProject(){

    }

    public ProfileProject(int id, int idProfile, int idProject, boolean finished, ProjectRole projectRole) {
        this.id = id;
        this.idProfile = idProfile;
        this.idProject = idProject;
        this.finished = finished;
        this.projectRole = projectRole;
    }

    public ProfileProject(int idProfile, int idProject, boolean finished, ProjectRole projectRole) {
        this.idProfile = idProfile;
        this.idProject = idProject;
        this.finished = finished;
        this.projectRole = projectRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public ProjectRole getProjectRole() {
        return projectRole;
    }

    public void setProjectRole(ProjectRole projectRole) {
        this.projectRole = projectRole;
    }
}
