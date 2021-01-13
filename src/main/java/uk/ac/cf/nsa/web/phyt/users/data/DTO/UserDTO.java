package uk.ac.cf.nsa.web.phyt.users.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.User;

public class UserDTO extends User {

    int UserID;
    String firstName;
    String lastName;
    String role;
    String userName;
    String password;

    //Constructor of User object
    public UserDTO (int UserID, String firstName, String lastName, String role, String userName, String password){

        super(UserID, firstName, lastName, role, userName, password);
    }
}
