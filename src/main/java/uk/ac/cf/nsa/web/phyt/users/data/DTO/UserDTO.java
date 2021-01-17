package uk.ac.cf.nsa.web.phyt.users.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.User;

public class UserDTO extends User {

    int UserID;
    String userName;
    String password;
    String role;

    //Constructor of User object
    public UserDTO (int UserID, String userName, String password, String role){

        super(UserID, userName, password);
        this.role = role;
    }

    @Override
    public int getUserID() {
        return UserID;
    }

    @Override
    public void setUserID(int userID) {
        UserID = userID;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
