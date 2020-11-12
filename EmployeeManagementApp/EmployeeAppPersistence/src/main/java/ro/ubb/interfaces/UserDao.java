package ro.ubb.interfaces;

import ro.ubb.exceptions.InvalidUsernameOrEmail;
import ro.ubb.models.User;

import java.sql.SQLException;

public interface UserDao {

    /**
     *
     * @param username a String
     * @return null, if the User doesn't exists, otherwise the user
     */
    User findByUsername(String username) throws ClassNotFoundException, SQLException;

    /**
     *
     * @param email a String
     * @return null, if the User doesn't exists, otherwise the user
     */
    User findByEmail(String email) throws ClassNotFoundException, SQLException;

    /**
     *
     * @param usernameOrEmail must be valid
     * @return false, if the Account is not blocked, otherwise returns true
     */
    boolean isLocked(String usernameOrEmail) throws SQLException, ClassNotFoundException, InvalidUsernameOrEmail;

}

