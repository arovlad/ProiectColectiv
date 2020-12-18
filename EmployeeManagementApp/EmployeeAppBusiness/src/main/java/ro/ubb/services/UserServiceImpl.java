package ro.ubb.services;

import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.SHAEncryption;
import ro.ubb.implementations.UserDaoImpl;
import ro.ubb.interfaces.UserDao;
import ro.ubb.interfaces.UserService;
import ro.ubb.models.LogInResponse;
import ro.ubb.models.RegisterResponse;
import ro.ubb.models.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final int WRONG_CREDENTIALS = 1;
    private static final int USER_IS_LOCKED = 2;
    private static final int SUCCESS = 3;

    private static final int EXISTING_EMAIL=4;
    private static final int EXISTING_USERNAME=5;
    private static final int EXISTING_USERNAME_AND_EMAIL=6;
    private static final int SUCCES_REGISTER=7;

    public LogInResponse logIn(String usernameOrEmail, String password) throws DbException {
        UserDao userDao = new UserDaoImpl();
        LogInResponse logInResponse = new LogInResponse();

        User user = userDao.findByUsername(usernameOrEmail);

        if (user == null) {
            user = userDao.findByEmail(usernameOrEmail);
        }

        if (user == null) {
            logInResponse.setLogInResult(WRONG_CREDENTIALS);
            logInResponse.setUserRoleId(-1);
            logInResponse.setNrRemainigAttempts(-1);
            logInResponse.setId(-1);
            return logInResponse;
        }

        if (user.getPassword().equals(user.getPassword())) {
            if (!(userDao.isLocked(usernameOrEmail))) {
                logInResponse.setLogInResult(SUCCESS);
                logInResponse.setUserRoleId(user.getId_role());
                logInResponse.setNrRemainigAttempts(user.getRemaining_attempts());
                logInResponse.setId(user.getId());
            } else {
                logInResponse.setLogInResult(USER_IS_LOCKED);
                logInResponse.setUserRoleId(user.getId_role());
                logInResponse.setNrRemainigAttempts(0);
                logInResponse.setId(user.getId());
            }
            return logInResponse;
        }else{
            logInResponse.setLogInResult(WRONG_CREDENTIALS);
            logInResponse.setUserRoleId(user.getId_role());
            userDao.decrementAttempts(user.getId());
            logInResponse.setNrRemainigAttempts(user.getRemaining_attempts());
            logInResponse.setId(user.getId());
            return logInResponse;
        }

    }
    public RegisterResponse register(String username, String email, String password) throws DbException {
        UserDao userDao = new UserDaoImpl();
        RegisterResponse registerResponse = new RegisterResponse();
        User userEmail=userDao.findByEmail(email);
        User userName=userDao.findByUsername(username);
        if(userEmail != null){
            registerResponse.setRegisterResult(EXISTING_EMAIL);
        }
        if (userName != null){
                   registerResponse.setRegisterResult(EXISTING_USERNAME);
        }
        if(userName != null && userEmail !=null){
            registerResponse.setRegisterResult(EXISTING_USERNAME_AND_EMAIL);
        }
        if(userName == null && userEmail == null)     {
            registerResponse.setRegisterResult(SUCCES_REGISTER);
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setId_role(1);
            UserDaoImpl u = new UserDaoImpl();
            u.save(newUser);
        }
        return registerResponse;
    }
}