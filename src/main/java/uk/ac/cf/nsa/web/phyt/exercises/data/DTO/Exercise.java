package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

//Exercise class to capture exercise data from database
public class Exercise {

    private int exerciseID;
    private String exerciseName;
    private String exerciseDesc;
    private String exerciseCat;
    private String thumbnailSrc;
    private String thumbnailAlt;
    private List<Image> images;
    private List<Video> videos;
    private Timestamp createdDate;
    private String dateStr;

    //Exercise constructors

    public Exercise(){
        this.exerciseID = 0;
        this.exerciseName = null;
        this.exerciseDesc = null;
        this.exerciseCat = null;
        this.thumbnailSrc = null;
        this.thumbnailAlt = null;
        images = null;
        videos = null;
        createdDate = null;
        dateStr = null;
    }

    public Exercise(int exerciseID, String exerciseName, String exerciseDesc, String exerciseCat, String thumbnailSrc, String thumbnailAlt, Timestamp createdDate) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
        this.thumbnailSrc = thumbnailSrc;
        this.thumbnailAlt = thumbnailAlt;
        images = null;
        videos = null;
        this.createdDate = createdDate;
        dateStr = null;
    }

    //getters & setters
    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseDesc() {
        return exerciseDesc;
    }

    public void setExerciseDesc(String exerciseDesc) {
        this.exerciseDesc = exerciseDesc;
    }

    public String getExerciseCat() {
        return exerciseCat;
    }

    public void setExerciseCat(String exerciseCat) {
        this.exerciseCat = exerciseCat;
    }

    public String getThumbnailSrc() {return thumbnailSrc;}

    public void setThumbnailSrc(String thumbnailSrc) {this.thumbnailSrc = thumbnailSrc;}

    public String getThumbnailAlt() {
        return thumbnailAlt;
    }

    public void setThumbnailAlt(String thumbnailAlt) {
        this.thumbnailAlt = thumbnailAlt;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    //Method to convert createdDate to String
    public String dateConverter(Timestamp date){
        String dateInString = null;
        Date date1 = new Date(date.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        dateInString = dateFormat.format(date1);
        this.setDateStr(dateInString);
        return dateInString;
    }
}
