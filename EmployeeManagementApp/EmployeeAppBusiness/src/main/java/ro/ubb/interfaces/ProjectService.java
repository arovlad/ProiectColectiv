package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.GetAllProjectsFromUserResponse;

public interface ProjectService {
    GetAllProjectsFromUserResponse findProjectsByUser(int user) throws DbException;
}
