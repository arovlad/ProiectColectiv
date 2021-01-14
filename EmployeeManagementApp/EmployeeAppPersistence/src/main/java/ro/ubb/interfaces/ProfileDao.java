package ro.ubb.interfaces;

import ro.ubb.constants.TechnologyArea;
import ro.ubb.exceptions.DbException;
import ro.ubb.models.Profile;

import java.util.List;

public interface ProfileDao {
    /**
     *
     * @param technologyArea - a technology area
     * @return - the list of all Profiles with the given technology area
     */
    List<Profile> getAllProfiles(TechnologyArea technologyArea) throws DbException;

    List<Profile> findAll() throws DbException;

    Profile getProfileByUserID(int idUser) throws DbException;

    Profile setVerified(int id) throws DbException;

    Profile setNotVerified(int id) throws DbException;
}
