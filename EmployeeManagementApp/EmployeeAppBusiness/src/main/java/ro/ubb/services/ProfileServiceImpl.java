package ro.ubb.services;

import ro.ubb.constants.ConsultingLevel;
import ro.ubb.constants.TechnologyArea;
import ro.ubb.exceptions.DbException;
import ro.ubb.implementations.ProfileDaoImpl;
import ro.ubb.implementations.ProjectDaoImpl;
import ro.ubb.implementations.RegionDaoImpl;
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

    @Override
    public GetProfileByUserIdResponse getProfileByUserId(int userId) throws DbException {
        ProfileDaoImpl profileDao = new ProfileDaoImpl();

        Profile profile = profileDao.getProfileByUserID(userId);

        GetProfileByUserIdResponse response = new GetProfileByUserIdResponse();
        response.setIdProfile(profile.getId());
        response.setFirstName(profile.getFirst_name());
        response.setLastName(profile.getLast_name());
        response.setPicture(profile.getPicture());

        String consultingLevelName = null;
        ConsultingLevel[] consultingLevels = ConsultingLevel.values();
        for (ConsultingLevel consultingLevel : consultingLevels) {
            if (consultingLevel.getId() == profile.getId_consulting_level()) {
                consultingLevelName = consultingLevel.getName();
            }
        }
        response.setConsultingLevelName(consultingLevelName);
        response.setVerified(profile.getVerified());
        RegionDaoImpl regionDao = new RegionDaoImpl();
        Region region = regionDao.find(profile.getId_region());
        response.setRegionName(region.getName());

        return response;
    }
}
