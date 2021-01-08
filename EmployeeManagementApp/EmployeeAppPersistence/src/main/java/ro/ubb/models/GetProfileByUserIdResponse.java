package ro.ubb.models;

public class GetProfileByUserIdResponse {
    private int idProfile;
    private String firstName;
    private String lastName;
    private String picture;
    private String consultingLevelName;
    private int verified;
    private String regionName;

    public GetProfileByUserIdResponse() {
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getConsultingLevelName() {
        return consultingLevelName;
    }

    public void setConsultingLevelName(String consultingLevelName) {
        this.consultingLevelName = consultingLevelName;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
