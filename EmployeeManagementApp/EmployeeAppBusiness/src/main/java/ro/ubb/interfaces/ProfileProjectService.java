package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;

import java.util.List;

public interface ProfileProjectService {

    List<Integer> findAllProjectsOfUser(int idProfile) throws DbException;
}
