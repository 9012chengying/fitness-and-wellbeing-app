package uk.ac.cf.nsa.web.phyt.users.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.User;

public class ClientDTO extends User {

    int UserID;
    String firstName;
    String lastName;
    String role ;
    int trainerID;
    String userName;
    String password;

    public ClientDTO(int UserID, String firstName, String lastName, String role, int trainerID, String userName, String password) {
        super(UserID, userName, password);
        this.trainerID=trainerID;
        this.firstName = firstName;
        this.lastName = lastName;
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


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
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
}

