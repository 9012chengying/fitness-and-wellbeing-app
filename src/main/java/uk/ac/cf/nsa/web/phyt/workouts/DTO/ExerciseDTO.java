package uk.ac.cf.nsa.web.phyt.workouts.DTO;

public class ExerciseDTO {
    private int workoutID;
    private int exerciseID;
    private String exerciseName;
    private String exerciseCategory;
    private String exerciseEquipment;
    private int thumbnailID;
    private String thumbnailSrc;
    private String altText;
    private String mediaType; //not sure if this is necessary

    public ExerciseDTO(int workoutID, int exerciseID, String exerciseName, String exerciseCategory, String exerciseEquipment, int thumbnailID, String thumbnailSrc, String altText, String mediaType) {
        this.workoutID = workoutID;
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseCategory = exerciseCategory;
        this.exerciseEquipment = exerciseEquipment;
        this.thumbnailID = thumbnailID;
        this.thumbnailSrc = thumbnailSrc;
        this.altText = altText;
        this.mediaType = mediaType;
    }

    public int getWorkoutID() {
        return workoutID;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseCategory() {
        return exerciseCategory;
    }

    public String getExerciseEquipment() {
        return exerciseEquipment;
    }

    public int getThumbnailID() {
        return thumbnailID;
    }

    public String getThumbnailSrc() {
        return thumbnailSrc;
    }

    public String getAltText() {
        return altText;
    }

    public String getMediaType() {
        return mediaType;
    }
}
