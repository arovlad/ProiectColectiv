package ro.ubb.mappers;

import ro.ubb.dtos.ProjectDto;
import ro.ubb.models.Project;

public class ProjectDtoMapper {
    public static Project mapProjectDtoToProject(ProjectDto projectDto){
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setId_customer(projectDto.getCustomer());
        project.setDuration(projectDto.getDuration());
        project.setDescription(projectDto.getDescription());
        project.setId_industry(projectDto.getIndustry());

        return project;
    }

    public static ProjectDto mapProjectToProjectDto(Project project){
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(project.getName());
        projectDto.setCustomer(project.getId_customer());
        projectDto.setDuration(project.getDuration());
        projectDto.setDescription(project.getDescription());
        projectDto.setIndustry(project.getId_industry());

        return projectDto;
    }
}
