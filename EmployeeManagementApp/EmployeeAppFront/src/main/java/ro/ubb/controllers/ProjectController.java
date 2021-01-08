package ro.ubb.controllers;

import ro.ubb.dtos.ProjectDto;
import ro.ubb.exceptions.DbException;

import ro.ubb.mappers.ProjectDtoMapper;
import ro.ubb.models.GetAllProjectsFromUserResponse;
import ro.ubb.models.Project;
import ro.ubb.services.ProjectServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/project")
public class ProjectController {
  public final ProjectServiceImpl projectService;
  public ProjectController(){
    this.projectService=new ProjectServiceImpl();
  }

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public GetAllProjectsFromUserResponse findProjectsByUser(@QueryParam("user") int user) throws DbException {
    return projectService.findProjectsByUser(user);
  }

  @GET
  @Path("/find")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ProjectDto find(@QueryParam("id") int id) throws DbException {
    return projectService.find(id);
  }

  @POST
  @Path("/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ProjectDto save(ProjectDto projectDto) throws DbException {
    return projectService.save(ProjectDtoMapper.mapProjectDtoToProject(projectDto));
  }

  @POST
  @Path("update")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ProjectDto update(ProjectDto projectDto, @QueryParam("id") int id) throws DbException {
    Project project = ProjectDtoMapper.mapProjectDtoToProject(projectDto);
    project.setId(id);
    return projectService.update(project);
  }

  @DELETE
  @Path("/delete")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ProjectDto delete(@QueryParam("id") int id) throws DbException {
    return projectService.delete(id);
  }
}
