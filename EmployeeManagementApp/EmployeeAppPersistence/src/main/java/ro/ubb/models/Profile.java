package ro.ubb.models;

public class Profile {
    private int id;
    private int id_user;
    private String first_name;
    private String last_name;
    private String picture;
    private int id_consulting_level;
    private int verified;
    private int id_region;

    public Profile(){

    }

    public Profile(int id, int id_user, String first_name, String last_name, String picture, int id_consulting_level, int verified, int id_region) {
        this.id = id;
        this.id_user = id_user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.picture = picture;
        this.id_consulting_level = id_consulting_level;
        this.verified = verified;
        this.id_region = id_region;
    }

    public Profile(int id_user, String first_name, String last_name, String picture, int id_consulting_level, int id_region) {
        this.id_user = id_user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.picture = picture;
        this.id_consulting_level = id_consulting_level;
        this.id_region = id_region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId_consulting_level() {
        return id_consulting_level;
    }

    public void setId_consulting_level(int id_consulting_level) {
        this.id_consulting_level = id_consulting_level;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }
}
