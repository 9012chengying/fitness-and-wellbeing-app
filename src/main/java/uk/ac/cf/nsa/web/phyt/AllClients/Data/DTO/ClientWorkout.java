package uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO;

import java.sql.Timestamp;

public class ClientWorkout extends Client {
    private String first_name;
    private String last_name;
    private boolean is_completed;
    private String completed;
    private Timestamp completed_at;
    private Timestamp created_at;
    private Timestamp complete_by;



    private int workoutID;


    public ClientWorkout(String first_name, String last_name, boolean is_completed, Timestamp completed_at, Timestamp created_at, Timestamp complete_by, int workoutID) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.is_completed = is_completed;
        this.completed_at = completed_at;
        this.created_at = created_at;
        this.complete_by = complete_by;
        this.workoutID = workoutID;
    }

    public ClientWorkout(){};

    public int getWorkoutID() {
        return workoutID;
    }

    public void setWorkoutID(int workoutID) {
        this.workoutID = workoutID;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }

    public Timestamp getComplete_by() {
        return complete_by;
    }

    public void setComplete_by(Timestamp complete_by) {
        this.complete_by = complete_by;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }


    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public Timestamp getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(Timestamp completed_at) {
        this.completed_at = completed_at;
    }
}
