package uk.ac.cf.nsa.web.phyt.UserInfo.Forms;

public class GeneralinfoPT {
    private int trainer_id;
    private String about;
    private String qualifications;
    private String location;

    public int getTrainer_id() {
        return trainer_id;
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

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
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
