package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.LogInResponse;
import ro.ubb.models.RegisterResponse;

public interface UserService {

    LogInResponse logIn(String usernameOrEmail, String password) throws DbException;
    RegisterResponse register(String username, String email, String password) throws DbException;

}