package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.Media;

//Image class
public class Image  extends Media{

    private int id;
    private String src;
    private String altText;
    private String Type;
    private int exerciseID;


    public Image() {
    }

    public Image(int id, String src, String altText, String Type, int exerciseID) {
        this.id = id;
        this.src = src;
        this.altText = altText;
        this.Type = Type;
        this.exerciseID = exerciseID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgSrc() {
        return src;
    }

    public void setImgSrc(String imgSrc) {
        this.src = imgSrc;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }
}
