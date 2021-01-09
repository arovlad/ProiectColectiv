package ro.ubb.controllers;

import ro.ubb.exceptions.DbException;
import ro.ubb.services.ProfileProjectServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profileproject")
public class ProfileProjectController {

  public final ProfileProjectServiceImpl profileProjectService;

  public ProfileProjectController() {
    this.profileProjectService = new ProfileProjectServiceImpl();
  }

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<Integer> findAllProjectsOfUser(@QueryParam("idProfile") int idProfile) throws DbException {
    return profileProjectService.findAllProjectsOfUser(idProfile);
  }
}
