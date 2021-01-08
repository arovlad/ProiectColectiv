package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;

import java.util.List;

public interface UserRoleDao {

    List<String> getAllUserRoleNames() throws DbException;
}
