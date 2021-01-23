package uk.ac.cf.nsa.web.phyt.trainer.DTO;

public class TrainerWorkoutDTO {

    private int workoutID;
    private int trainerID;
    private int clientID;
    private String clientUsername;
    private int exerciseCount;
    private String createdAt;
    private String dueDate;
    private boolean completed;
    private String completedAt;
    private int thumbnailID;
    private String imageSrc;
    private String imageAlt;

    public TrainerWorkoutDTO(int workoutID, int trainerID, int clientID, String clientUsername, int exerciseCount, String createdAt, String dueDate, boolean completed, String completedAt, int thumbnailID, String imageSrc, String imageAlt) {
        this.workoutID = workoutID;
        this.trainerID = trainerID;
        this.clientID = clientID;
        this.clientUsername = clientUsername;
        this.exerciseCount = exerciseCount;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
        this.completed = completed;
        this.completedAt = completedAt;
        this.thumbnailID = thumbnailID;
        this.imageSrc = imageSrc;
        this.imageAlt = imageAlt;
    }

    public int getWorkoutID() {
        return workoutID;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public int getThumbnailID() {
        return thumbnailID;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getImageAlt() {
        return imageAlt;
    }
}
