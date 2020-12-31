package ro.ubb.controllers;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.FilterByTechnologyResponse;
import ro.ubb.models.GetProfileByUserIdResponse;
import ro.ubb.models.Profile;
import ro.ubb.services.ProfileServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profile")
public class ProfileController {

  private final ProfileServiceImpl profileService;

  public ProfileController() {
    this.profileService = new ProfileServiceImpl();
  }

  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public FilterByTechnologyResponse filterByTechnology(@QueryParam("technology") String technology) throws DbException {
    return profileService.filterByTechnology(technology);
  }

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Profile> findAll() throws DbException {
    return profileService.findAll();
  }

  @GET
  @Path("/getByUser")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public GetProfileByUserIdResponse getProfileByUserId(@QueryParam("userID") int userID) throws DbException {
    return profileService.getProfileByUserId(userID);
  }
}
