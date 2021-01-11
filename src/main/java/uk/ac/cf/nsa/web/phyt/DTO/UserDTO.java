package uk.ac.cf.nsa.web.phyt.DTO;

public class UserDTO {

    private int userID;
    private String username;
    private String password;


    public UserDTO(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;

    }

    public int getUserId() {
        return userID;
    }

    public void setUserId(int userId) {this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
