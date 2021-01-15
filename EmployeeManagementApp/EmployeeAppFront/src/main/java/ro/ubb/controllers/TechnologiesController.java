package ro.ubb.controllers;

import ro.ubb.exceptions.DbException;
import ro.ubb.services.TechnologiesServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/technologies")
public class TechnologiesController {

  @GET
  @Path("/technologies")
  @Produces(MediaType.APPLICATION_JSON)
  public List<String> getAllTechnologies() throws DbException {
    return new TechnologiesServiceImpl().findAll();
  }
}
