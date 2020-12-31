package ro.ubb.interfaces;

import ro.ubb.exceptions.DbException;
import ro.ubb.models.FilterByTechnologyResponse;
import ro.ubb.models.GetProfileByUserIdResponse;
import ro.ubb.models.Profile;

import java.util.List;

public interface ProfileService {

    FilterByTechnologyResponse filterByTechnology(String technology) throws DbException;

    List<Profile> findAll() throws DbException;

    GetProfileByUserIdResponse getProfileByUserId(int userId) throws DbException;
}
