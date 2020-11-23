package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.LogInResponse;

public interface UserService {

    LogInResponse logIn(String usernameOrEmail, String password) throws DbException;
}