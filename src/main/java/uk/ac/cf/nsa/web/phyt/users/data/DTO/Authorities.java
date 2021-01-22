package uk.ac.cf.nsa.web.phyt.users.data.DTO;

public class Authorities {

    private String username;
    private String authGroup;

    public Authorities(String username, String authGroup) {
        this.username = username;
        this.authGroup = authGroup;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthGroup() {
        return authGroup;
    }

    public void setAuthGroup(String authGroup) {
        this.authGroup = authGroup;
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "username='" + username + '\'' +
                ", authGroup='" + authGroup + '\'' +
                '}';
    }
}
