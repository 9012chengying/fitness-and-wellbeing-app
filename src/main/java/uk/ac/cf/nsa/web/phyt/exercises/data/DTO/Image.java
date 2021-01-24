package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.Media;

//Image class
public class Image {

    private int id;
    private String imgSrc;
    private String altText;
    private String type;
    private int exerciseID;


    public Image() {
    }

    public Image(int id, String imgSrc, String altText, String type, int exerciseID) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.altText = altText;
        this.type = type;
        this.exerciseID = exerciseID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }
}
