package ro.ubb.dtos;

import ro.ubb.constants.ProjectRole;

public class ProfileProjectDto {
    private int id_Profile;
    private int id_Project;
    private int finished;
    private int id_role;

    public ProfileProjectDto() {
    }

    public int getId_Profile() {
        return id_Profile;
    }

    public void setId_Profile(int id_Profile) {
        this.id_Profile = id_Profile;
    }

    public int getId_Project() {
        return id_Project;
    }

    public void setId_Project(int id_Project) {
        this.id_Project = id_Project;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
}
