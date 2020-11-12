package ro.ubb.services;

import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.UserDaoImpl;
import ro.ubb.interfaces.UserDao;
import ro.ubb.models.User;

public class UserServiceImpl {
    private static final int WRONG_CREDENTIALS = 1;
    private static final int USER_IS_LOCKED = 2;
    private static final int SUCCESS = 3;

    public int logIn(String usernameOrEmail, String password) throws DbException {
        UserDao userDao = new UserDaoImpl();

        User user = userDao.findByUsername(usernameOrEmail);

        if (user == null) {
            user = userDao.findByEmail(usernameOrEmail);
        }

        if (user == null) {
            return WRONG_CREDENTIALS;
        }

        if (userDao.isLocked(usernameOrEmail)) {
            return USER_IS_LOCKED;
        }

        if (user.getPassword().equals(password)) {
            return SUCCESS;
        }

        return WRONG_CREDENTIALS;
    }
}