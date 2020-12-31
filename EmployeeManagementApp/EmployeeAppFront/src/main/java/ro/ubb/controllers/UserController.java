package ro.ubb.controllers;

import ro.ubb.dtos.IntegerResponseDto;
import ro.ubb.dtos.LoginDto;
import ro.ubb.dtos.RegisterDto;
import ro.ubb.exceptions.DbException;
import ro.ubb.services.UserServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//rest stuff
@Path("/user")
public class UserController {

  private final UserServiceImpl userService;

  public UserController() {
    this.userService = new UserServiceImpl();
  }

  @POST
  @Path("/login")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public IntegerResponseDto login(LoginDto loginDto) throws DbException {
    IntegerResponseDto integerResponseDto = new IntegerResponseDto();
    integerResponseDto.setResponse(userService.logIn(loginDto.getUsernameOrEmail(), loginDto.getPassword()));
    return integerResponseDto;
  }

  @POST
  @Path("/register")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public IntegerResponseDto register(RegisterDto registerDto) throws DbException {
    IntegerResponseDto integerResponseDto = new IntegerResponseDto();
    integerResponseDto.setRegisterResponse(userService.register(registerDto.getUsername(), registerDto.getEmail(), registerDto.getPassword()));
    return integerResponseDto;
  }


//    @GET
//    @Path("/{username}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public IntegerResponseDto meth(@PathParam("username") String username) {
//        IntegerResponseDto integerResponseDto=new IntegerResponseDto();
//        integerResponseDto.setUsername(username);
//        return integerResponseDto;
//    }

}

