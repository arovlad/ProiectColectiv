package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.Project;

import java.util.List;

public interface ProjectDao {

    /**
     *
     * @param id an int
     * @return all projcts for specific user
     * @throws DbException
     */
    List<Project> findProjectsByUser(int id) throws DbException;
}
