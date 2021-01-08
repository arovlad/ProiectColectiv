package ro.ubb.controllers;

import ro.ubb.exceptions.DbException;
import ro.ubb.interfaces.UserRoleService;
import ro.ubb.services.UserRoleServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/userrole")
public class UserRoleController {
  UserRoleService userRoleService = new UserRoleServiceImpl();

  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public List<String> findAllUserRoleNames() throws DbException {
    return userRoleService.getAllUserRoleNames();
  }
}
