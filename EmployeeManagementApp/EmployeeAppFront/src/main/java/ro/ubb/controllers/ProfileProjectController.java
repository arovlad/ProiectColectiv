package ro.ubb.controllers;


import ro.ubb.dtos.ProfileProjectDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.mappers.ProfileProjectDtoMapper;
import ro.ubb.services.ProfileProjectServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/profileproject")
public class ProfileProjectController {

  @POST
  @Path("/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ProfileProjectDto save(ProfileProjectDto profileProjectDto) throws DbException {
      return new ProfileProjectServiceImpl().save(ProfileProjectDtoMapper.mapProfileProjectDtoToProfileProject(profileProjectDto));
  }

}