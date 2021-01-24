package uk.ac.cf.nsa.web.phyt.model;

public class Media {

    int id;
    String src;
    String altText;
    String Type;
    int exerciseID;

    public Media (){}


    public Media(String src, String altText, String Type, int exerciseID){
        this.src = src;
        this.altText = altText;
        this.Type = Type;
        this.exerciseID = exerciseID;
    }
    public Media(int id, String src, String altText, String Type, int exerciseID) {
        this.id = id;
        this.src = src;
        this.altText = altText;
        this.exerciseID = exerciseID;
        this.Type = Type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
