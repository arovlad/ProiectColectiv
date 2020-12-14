package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.User;

public interface UserDao {

    /**
     * @param username a String
     * @return null, if the User doesn't exists, otherwise the user
     */
    User findByUsername(String username) throws DbException;

    /**
     * @param email a String
     * @return null, if the User doesn't exists, otherwise the user
     */
    User findByEmail(String email) throws DbException;

    /**
     * @param usernameOrEmail must be valid
     * @return false, if the Account is not blocked, otherwise returns true
     */
    boolean isLocked(String usernameOrEmail) throws DbException;
    
    void decrementAttempts(int id)throws DbException;

}