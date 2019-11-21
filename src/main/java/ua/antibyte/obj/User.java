package ua.antibyte.obj;

public class User {
    private int id;
    private String userMobileNumber;
    private String userPassword;

    public User(String userMobileNumber, String userPassword) {
        this.userMobileNumber = userMobileNumber;
        this.userPassword = userPassword;
    }

    public int getId() {
        return id;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
