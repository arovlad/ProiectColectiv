package ro.ubb.controllers;

import java.util.List;
import ro.ubb.dtos.ProfileProjectDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.mappers.ProfileProjectDtoMapper;
import ro.ubb.services.ProfileProjectServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/profileproject")
public class ProfileProjectController {

  public final ProfileProjectServiceImpl profileProjectService;

  public ProfileProjectController() {
    this.profileProjectService = new ProfileProjectServiceImpl();
  }

  @POST
  @Path("/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ProfileProjectDto save(ProfileProjectDto profileProjectDto) throws DbException {
      return new ProfileProjectServiceImpl().save(ProfileProjectDtoMapper.mapProfileProjectDtoToProfileProject(profileProjectDto));
  }

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<Integer> findAllProjectsOfUser(@QueryParam("idProfile") int idProfile) throws DbException {
    return profileProjectService.findAllProjectsOfUser(idProfile);
  }
}
