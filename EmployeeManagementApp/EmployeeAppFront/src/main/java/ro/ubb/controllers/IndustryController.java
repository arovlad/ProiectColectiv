package ro.ubb.controllers;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.IndustryService;
import ro.ubb.services.IndustryServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/industry")
public class IndustryController {
  IndustryService industryService = new IndustryServiceImpl();

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<String> findAllIndustryNames() throws DbException {
    return industryService.getAllIndustryNames();
  }
}
