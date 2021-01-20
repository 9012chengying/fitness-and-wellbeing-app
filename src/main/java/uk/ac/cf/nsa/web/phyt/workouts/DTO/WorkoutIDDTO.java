package uk.ac.cf.nsa.web.phyt.workouts.DTO;

public class WorkoutIDDTO {
    private int workoutID;
    private int clientID;
    private boolean isCompleted;

    public WorkoutIDDTO(int workoutID, int clientID, boolean isCompleted) {
        this.workoutID = workoutID;
        this.clientID = clientID;
        this.isCompleted = isCompleted;
    }

    public int getWorkoutID() {
        return workoutID;
    }

    public int getClientID() {
        return clientID;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
