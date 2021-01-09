package ro.ubb.services;

import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.ProfileProjectDaoImpl;
import ro.ubb.interfaces.ProfileProjectService;

import java.util.List;

public class ProfileProjectServiceImpl implements ProfileProjectService {
    @Override
    public List<Integer> findAllProjectsOfUser(int idProfile) throws DbException {
        ProfileProjectDaoImpl profileProjectDao = new ProfileProjectDaoImpl();
        return profileProjectDao.findAllProjectsOfUser(idProfile);
    }
}