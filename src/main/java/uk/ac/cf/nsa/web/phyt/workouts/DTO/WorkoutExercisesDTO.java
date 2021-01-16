package uk.ac.cf.nsa.web.phyt.workouts.DTO;

public class WorkoutExercisesDTO {
    private int workoutID;
    private int clientID;
    private int exerciseLength;
    private int exerciseRest;
    private int repRest;
    private int reps;
    private String createdDate;
    private String dueDate;
    private String completedDate;
    private int exerciseIDs;
    private String exerciseName;
    private String exerciseCategory;
    private String exerciseEquipment;
    private int exerciseThumbnailID;

    public WorkoutExercisesDTO(int workoutID, int clientID, int exerciseLength, int exerciseRest, int repRest, int reps, String createdDate, String dueDate, String completedDate, int exerciseIDs, String exerciseName, String exerciseCategory, String exerciseEquipment, int exerciseThumbnailID) {
        this.workoutID = workoutID;
        this.clientID = clientID;
        this.exerciseLength = exerciseLength;
        this.exerciseRest = exerciseRest;
        this.repRest = repRest;
        this.reps = reps;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
        this.completedDate = completedDate;
        this.exerciseIDs = exerciseIDs;
        this.exerciseName = exerciseName;
        this.exerciseCategory = exerciseCategory;
        this.exerciseEquipment = exerciseEquipment;
        this.exerciseThumbnailID = exerciseThumbnailID;
    }

    public int getWorkoutID() {
        return workoutID;
    }

    public int getClientID() {
        return clientID;
    }

    public int getExerciseLength() {
        return exerciseLength;
    }

    public int getExerciseRest() {
        return exerciseRest;
    }

    public int getRepRest() {
        return repRest;
    }

    public int getReps() {
        return reps;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public int getExerciseIDs() {
        return exerciseIDs;
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

    public int getExerciseThumbnailID() {
        return exerciseThumbnailID;
    }
}
