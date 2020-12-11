package ro.ubb.models;

public class LogInResponse {
    private int logInResult;
    private int userRoleId;
    private int nrRemainigAttempts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public LogInResponse() {
    }

    public int getLogInResult() {
        return logInResult;
    }

    public void setLogInResult(int logInResult) {
        this.logInResult = logInResult;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getNrRemainigAttempts() {
        return nrRemainigAttempts;
    }

    public void setNrRemainigAttempts(int nrRemainigAttempts) {
        this.nrRemainigAttempts = nrRemainigAttempts;
    }
}
