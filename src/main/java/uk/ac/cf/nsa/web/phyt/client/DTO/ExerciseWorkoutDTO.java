package uk.ac.cf.nsa.web.phyt.client.DTO;

public class ExerciseWorkoutDTO {
    private int workoutID;
    private int exerciseID;
    private String exerciseName;
    private String exerciseCategory;
    private String thumbnailImg;
    private String thumbnailAlt;

    public ExerciseWorkoutDTO(int workoutID, int exerciseID, String exerciseName, String exerciseCategory, String thumbnailImg, String thumbnailAlt) {
        this.workoutID = workoutID;
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseCategory = exerciseCategory;
        this.thumbnailImg = thumbnailImg;
        this.thumbnailAlt = thumbnailAlt;
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

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public String getThumbnailAlt() {
        return thumbnailAlt;
    }
}
