package ro.ubb.controllers;

import ro.ubb.dtos.RegionDto;
import ro.ubb.dtos.SkillDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.mappers.RegionDtoMapper;
import ro.ubb.mappers.SkillDtoMapper;
import ro.ubb.services.RegionServiceImpl;
import ro.ubb.services.SkillServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/region")
public class RegionController {

  @POST
  @Path("/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public RegionDto save(RegionDto regionDto) throws DbException {
    return new RegionServiceImpl().save(RegionDtoMapper.mapRegionDtoToRegion(regionDto));
  }

  @GET
  @Path("/delete")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public int delete(@QueryParam("id") int id) throws DbException {
    return new RegionServiceImpl().delete(id);
  }
}
