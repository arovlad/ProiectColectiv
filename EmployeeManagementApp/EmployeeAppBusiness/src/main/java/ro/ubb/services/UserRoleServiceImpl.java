package ro.ubb.services;

import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.UserRoleDaoImpl;
import ro.ubb.interfaces.UserRoleDao;
import ro.ubb.interfaces.UserRoleService;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public List<String> getAllUserRoleNames() throws DbException {
        UserRoleDao userRoleDao = new UserRoleDaoImpl();

        return userRoleDao.getAllUserRoleNames();
    }
}
