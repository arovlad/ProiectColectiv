package ro.ubb.services;

import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.UserDaoImpl;
import ro.ubb.interfaces.UserDao;
import ro.ubb.interfaces.UserService;
import ro.ubb.models.LogInResponse;
import ro.ubb.models.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final int WRONG_CREDENTIALS = 1;
    private static final int USER_IS_LOCKED = 2;
    private static final int SUCCESS = 3;

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
            return logInResponse;
        }

        if (user.getPassword().equals(password)) {
            if (!(userDao.isLocked(usernameOrEmail))) {
                logInResponse.setLogInResult(SUCCESS);
                logInResponse.setUserRoleId(user.getId_role());
                logInResponse.setNrRemainigAttempts(user.getRemaining_attempts());
            } else {
                logInResponse.setLogInResult(USER_IS_LOCKED);
                logInResponse.setUserRoleId(user.getId_role());
                logInResponse.setNrRemainigAttempts(0);
            }
            return logInResponse;
        }

        logInResponse.setLogInResult(WRONG_CREDENTIALS);
        logInResponse.setUserRoleId(-1);
        logInResponse.setNrRemainigAttempts(-1);
        return logInResponse;

    }
}