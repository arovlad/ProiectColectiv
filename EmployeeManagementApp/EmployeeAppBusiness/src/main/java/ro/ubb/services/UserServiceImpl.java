package ro.ubb.services;

public class UserServiceImpl {
    private static final int WRONG_CREDENTIALS = 1;
    private static final int USER_IS_LOCKED = 2;
    private static final int SUCCESS = 3;

    public int logIn(String usernameOrEmail, String password) {
        UserDao userDao = new UserDao();

        User user = userDao.findUserByUsername(usernameOrEmail);

        if (user == null) {
            User user = userDao.findUserByEmail(usernameOrEmail);
        }

        if (user == null) {
            return WRONG_CREDENTIALS;
        }

        if (userDao.isLocked(usernameOrEmail)) {
            return USER_IS_LOCKED;
        }

        return SUCCESS;
    }
}