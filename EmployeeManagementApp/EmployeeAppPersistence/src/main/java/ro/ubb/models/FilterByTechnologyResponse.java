package ro.ubb.models;

import java.util.List;

public class FilterByTechnologyResponse {
    private boolean profilesFound;
    private List<Profile> profileList;

    public FilterByTechnologyResponse() {
    }

    public boolean isProfilesFound() {
        return profilesFound;
    }

    public void setProfilesFound(boolean profilesFound) {
        this.profilesFound = profilesFound;
    }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }
}
