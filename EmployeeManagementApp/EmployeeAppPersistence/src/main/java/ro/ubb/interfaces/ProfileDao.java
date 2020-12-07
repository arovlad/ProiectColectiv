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
}
