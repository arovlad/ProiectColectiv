package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;

public interface UserService {

    int logIn(String usernameOrEmail, String password) throws DbException;
}