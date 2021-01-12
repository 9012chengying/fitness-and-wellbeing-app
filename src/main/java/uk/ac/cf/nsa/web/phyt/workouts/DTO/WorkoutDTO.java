package uk.ac.cf.nsa.web.phyt.workouts.DTO;

import java.sql.Date;
import java.sql.Time;

public class WorkoutDTO {
    private int id;
    private int clientID;
    private int exerciseLength;
    private int restLength;
    private int repRest;
    private int reps;
    private boolean completed;
    private Date completedDate;
    private Date createdDate;

    public WorkoutDTO(int id, int clientID, int exerciseLength, int restLength, int repRest, int reps, boolean completed, Date completedDate, Date createdDate) {
        this.id = id;
        this.clientID = clientID;
        this.exerciseLength = exerciseLength;
        this.restLength = restLength;
        this.repRest = repRest;
        this.reps = reps;
        this.completed = completed;
        this.completedDate = completedDate;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public int getClientID() {
        return clientID;
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

    public boolean isCompleted() {
        return completed;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String workoutLength() {
        int totalRepLength = 4  * (exerciseLength + restLength); //4 needs to be replaced by exercise count
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
