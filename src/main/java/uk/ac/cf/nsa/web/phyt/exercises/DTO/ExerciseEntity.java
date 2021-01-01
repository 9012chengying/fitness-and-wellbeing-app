package uk.ac.cf.nsa.web.phyt.exercises.DTO;

//Exercise entity class to capture exercise data from database
public class ExerciseEntity {

    private int exerciseID;
    private String exerciseName;
    private String exerciseDesc;
    private String exerciseCat;
    private String thumbnailSrc;
    private String thumbnailAlt;

    //TODO add lists for images and videos

    public ExerciseEntity(int exerciseID, String exerciseName, String exerciseDesc, String exerciseCat, String thumbnailSrc, String thumbnailAlt) {
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseDesc = exerciseDesc;
        this.exerciseCat = exerciseCat;
        this.thumbnailSrc = thumbnailSrc;
        this.thumbnailAlt = thumbnailAlt;
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

}
