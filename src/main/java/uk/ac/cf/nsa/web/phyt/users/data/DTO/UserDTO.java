package uk.ac.cf.nsa.web.phyt.users.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.User;

public class UserDTO extends User {

    int UserID;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    //Constructor of User object
    public UserDTO (int UserID, String userName, String password, String firstName, String lastName, String email){
        super(UserID, userName, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "UserID=" + UserID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
