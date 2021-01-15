package uk.ac.cf.nsa.web.phyt.workouts.DTO;

import java.sql.Date;

public class WorkoutDTO {
    private int id;
    private int clientID;
    private int exerciseCount;
    private int exerciseLength;
    private int restLength;
    private int repRest;
    private int reps;
    private String dueDate;
    private boolean completed;
    private String completedDate;
    private String createdDate;
    private String imageSrc;
    private String altText;
    private String type;

    public WorkoutDTO(int id, int clientID, int exerciseCount, int exerciseLength, int restLength, int repRest, int reps, String dueDate, boolean completed, String completedDate, String createdDate, String imageSrc, String altText, String type) {
        this.id = id;
        this.clientID = clientID;
        this.exerciseCount = exerciseCount;
        this.exerciseLength = exerciseLength;
        this.restLength = restLength;
        this.repRest = repRest;
        this.reps = reps;
        this.dueDate = dueDate;
        this.completed = completed;
        this.completedDate = completedDate;
        this.createdDate = createdDate;
        this.imageSrc = imageSrc;
        this.altText = altText;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getClientID() {
        return clientID;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public int getExerciseLength() {
        return exerciseLength;
    }

    public int getRestLength() {
        return restLength;
    }

    public int getRepRest() {
        return repRest;
    }

    public int getReps() {
        return reps;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getAltText() {
        return altText;
    }

    public String getType() {
        return type;
    }

    public String workoutLength() {
        int totalRepLength = exerciseCount  * (exerciseLength + restLength);
        int totalWorkoutLengthInSeconds = reps * (totalRepLength + repRest);
        int hh = totalWorkoutLengthInSeconds / 3600;
        int remainder = totalWorkoutLengthInSeconds % 3600;
        int mm = remainder / 60;
        int ss = remainder % 60;
        if (hh == 0) {
            if (ss < 10) {
                return mm + ":0" + ss;
            } else {
                return mm + ":" + ss;
            }
        } else {
            return hh + ":" + mm + ":" + ss;
        }
    }
}
