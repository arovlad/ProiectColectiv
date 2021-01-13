package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;

import java.util.List;

public interface ProfileProjectDao {

    List<Integer> findAllProjectsOfUser(int idProfile) throws DbException;
}
