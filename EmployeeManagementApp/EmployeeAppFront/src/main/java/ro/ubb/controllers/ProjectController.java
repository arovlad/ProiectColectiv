package ro.ubb.controllers;

import ro.ubb.exceptions.DbException;

import ro.ubb.models.GetAllProjectsFromUserResponse;
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
}
