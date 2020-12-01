package ro.ubb.controllers;

import ro.ubb.dtos.SkillDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.mappers.SkillDtoMapper;
import ro.ubb.services.SkillServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/skills")
public class SkillsController {

  @GET
  @Path("/technologyareas")
  @Produces(MediaType.APPLICATION_JSON)
  public List<String> getAllTechnologyAreas() {
    return new SkillServiceImpl().getAllTechnologyAreas();
  }

  @POST
  @Path("/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public SkillDto save(SkillDto skillDto) throws DbException {
    return new SkillServiceImpl().save(SkillDtoMapper.mapSkillDtoToSkill(skillDto));
  }
}
