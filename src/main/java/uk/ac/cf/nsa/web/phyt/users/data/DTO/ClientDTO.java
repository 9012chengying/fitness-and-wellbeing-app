package uk.ac.cf.nsa.web.phyt.users.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.User;

public class ClientDTO extends User {

    int UserID;
    String firstName;
    String lastName;
    String role ;
    String userName;
    String password;

    public ClientDTO(int UserID, String firstName, String lastName, String role, String userName, String password) {
        super(UserID, firstName, lastName, role, userName, password);
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
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
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

