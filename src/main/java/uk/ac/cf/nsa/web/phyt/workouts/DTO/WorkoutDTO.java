package uk.ac.cf.nsa.web.phyt.workouts.DTO;

import java.sql.Date;
import java.sql.Time;

public class WorkoutDTO {
    private int id;
    private int clientID;
    private Time exerciseLength;
    private Time exerciseRest;
    private Time repRest;
    private int reps;
    private boolean completed;
    private Date completedDate;

    public WorkoutDTO(int id, int clientID, Time exerciseLength, Time exerciseRest, Time repRest, int reps, boolean completed, Date completedDate) {
        this.id = id;
        this.clientID = clientID;
        this.exerciseLength = exerciseLength;
        this.exerciseRest = exerciseRest;
        this.repRest = repRest;
        this.reps = reps;
        this.completed = completed;
        this.completedDate = completedDate;
    }

    public int getId() {
        return id;
    }

    public int getClientID() {
        return clientID;
    }

    public Time getExerciseLength() {
        return exerciseLength;
    }

    public Time getExerciseRest() {
        return exerciseRest;
    }

    public Time getRepRest() {
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
}
