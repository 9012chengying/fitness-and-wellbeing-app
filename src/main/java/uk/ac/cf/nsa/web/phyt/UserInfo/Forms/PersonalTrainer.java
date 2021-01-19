package uk.ac.cf.nsa.web.phyt.UserInfo.Forms;

public class PersonalTrainer {
    private int ptID = 1;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private  String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPtID() {
        return ptID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPtID(int ptID) {
        this.ptID = ptID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
