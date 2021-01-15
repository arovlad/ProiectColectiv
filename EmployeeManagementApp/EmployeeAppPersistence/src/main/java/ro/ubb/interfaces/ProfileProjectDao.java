package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.ProfileProject;

import java.util.List;

public interface ProfileProjectDao {

    List<Integer> findAllProjectsOfUser(int idProfile) throws DbException;

    int unassign(int idProfile, int idProject) throws DbException;
}
