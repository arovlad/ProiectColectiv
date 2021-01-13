package ro.ubb.mappers;


import ro.ubb.constants.ProjectRole;
import ro.ubb.dtos.ProfileProjectDto;
import ro.ubb.models.ProfileProject;

public class ProfileProjectDtoMapper {
    public static ProfileProject mapProfileProjectDtoToProfileProject(ProfileProjectDto profileProjectDto){
        ProfileProject profileProject = new ProfileProject();
        profileProject.setIdProfile(profileProjectDto.getId_Profile());
        profileProject.setIdProject(profileProjectDto.getId_Project());
        boolean finished;
        if(profileProjectDto.getFinished() == 1){
            finished = true;
        }
        else{
            finished = false;
        }
        profileProject.setFinished(finished);
        ProjectRole[] projectRoles = ProjectRole.values();
        int id = profileProjectDto.getId_role();
        ProjectRole projectRole = null;
        for (ProjectRole pR : projectRoles){
            if(pR.getId() == id){
                projectRole = pR;
            }
        }
        profileProject.setProjectRole(projectRole);

        return profileProject;
    }

    public static ProfileProjectDto mapProfileProjectToProfileProjectDto(ProfileProject profileProject){
        ProfileProjectDto profileProjectDto = new ProfileProjectDto();
        profileProjectDto.setId_Profile(profileProject.getIdProfile());
        profileProjectDto.setId_Project(profileProject.getIdProject());
        int finished;
        if(profileProject.isFinished()){
            finished = 1;
        }
        else{
            finished = 0;
        }
        profileProjectDto.setFinished(finished);
        ProjectRole projectRole = profileProject.getProjectRole();
        ProjectRole[] projectRoles = ProjectRole.values();
        int p = -1;
        for (ProjectRole pR : projectRoles){
            if (pR == projectRole) {
                p = pR.getId();
            }
        }
        
        profileProjectDto.setId_role(p);

        return profileProjectDto;
    }
}
