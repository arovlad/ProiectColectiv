package ro.ubb.models;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private int id_role;
    private int failed_attempts;

    public User(int id, String username, String email, String password, int id_role, int failed_attempts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.id_role = id_role;
        this.failed_attempts = failed_attempts;
    }

    public User(String username, String email, String password, int id_role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.id_role = id_role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public int getFailed_attempts() {
        return failed_attempts;
    }

    public void setFailed_attempts(int failed_attempts) {
        this.failed_attempts = failed_attempts;
    }
}
