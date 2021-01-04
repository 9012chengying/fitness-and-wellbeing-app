package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;

import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.ExerciseRepository;

import java.util.*;

//Exercise entity class to capture exercise data from database
public class Exercise {

    private int exerciseID;
    private String exerciseName;
    private String exerciseDesc;
    private String exerciseCat;
    private String thumbnailSrc;
    private String thumbnailAlt;
    private List<Image> images;
    private List<Video> videos;

    //Exercise constructor
    public Exercise(int exerciseID, String exerciseName, String exerciseDesc, String exerciseCat, String thumbnailSrc, String thumbnailAlt) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
        this.thumbnailSrc = thumbnailSrc;
        this.thumbnailAlt = thumbnailAlt;
        images = null;
        videos = null;
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
}
