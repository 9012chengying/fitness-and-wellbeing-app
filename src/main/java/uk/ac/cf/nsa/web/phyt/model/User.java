package uk.ac.cf.nsa.web.phyt.model;

//User entity class to capture user data from database following log in
public class User {

    int UserID;
    String userName;
    String password;

    //Constructor of User object
    public User(){
        this.UserID=0;
        this.userName = null;
        this.password=null;
    }

    public User (int UserID, String userName, String password){
        this.UserID = UserID;
        this.userName = userName;
        this.password = password;
    }


    //getters & setters
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

