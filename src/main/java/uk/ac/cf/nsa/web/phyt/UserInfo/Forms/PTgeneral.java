package uk.ac.cf.nsa.web.phyt.UserInfo.Forms;

public class PTgeneral {

    private int id;
    private String about;
    private String qualifications;
    private String location;


    public int getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
