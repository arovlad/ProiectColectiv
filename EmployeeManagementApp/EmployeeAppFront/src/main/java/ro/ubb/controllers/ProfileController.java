package ro.ubb.controllers;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.FilterByTechnologyResponse;
import ro.ubb.models.GetAllProjectsFromUserResponse;
import ro.ubb.services.ProfileServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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


}
