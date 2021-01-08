package ro.ubb.services;

import ro.ubb.constants.TechnologyArea;
import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.ProfileDaoImpl;
import ro.ubb.implementations.ProjectDaoImpl;
import ro.ubb.interfaces.ProfileDao;
import ro.ubb.interfaces.ProfileService;
import ro.ubb.models.*;

import java.util.List;

public class ProfileServiceImpl implements ProfileService {
    @Override
    public FilterByTechnologyResponse filterByTechnology(String technology) throws DbException {
        ProfileDaoImpl profileDao = new ProfileDaoImpl();

        TechnologyArea myTechnologyArea = null;

        TechnologyArea[] technologyAreas = TechnologyArea.values();
        for (TechnologyArea area : technologyAreas) {
            if (area.getTechnologyArea().equals(technology)) {
                myTechnologyArea = area;
            }
        }

        List<Profile> profiles = profileDao.getAllProfiles(myTechnologyArea);
        boolean profilesFound = !profiles.isEmpty();
        FilterByTechnologyResponse response = new FilterByTechnologyResponse();
        response.setProfilesFound(profilesFound);
        response.setProfileList(profiles);

        return response;
    }

    @Override
    public List<Profile> findAll() throws DbException {
        ProfileDao profileDao=new ProfileDaoImpl();

        return profileDao.findAll();
    }

}
