package ro.ubb.controllers;

import ro.ubb.dtos.SkillDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.mappers.SkillDtoMapper;
import ro.ubb.services.SkillServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/skill")
public class SkillController {

  @POST
  @Path("/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public SkillDto save(SkillDto skillDto) throws DbException {
    return new SkillServiceImpl().save(SkillDtoMapper.mapSkillDtoToSkill(skillDto));
  }
}
