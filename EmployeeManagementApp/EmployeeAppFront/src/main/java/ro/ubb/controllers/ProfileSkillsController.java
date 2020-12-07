package ro.ubb.controllers;

import ro.ubb.dtos.ProfileSkillDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.mappers.ProfileSkillsDtoMapper;
import ro.ubb.services.ProfileSkillsServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/profileskills")
public class ProfileSkillsController {

  @POST
  @Path("/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ProfileSkillDto save(ProfileSkillDto profileSkillDto) throws DbException {
    return new ProfileSkillsServiceImpl().save(ProfileSkillsDtoMapper
      .mapProfileSkillsDtoToProfileSkills(profileSkillDto));
  }
}
