package uk.ac.cf.nsa.web.phyt.workouts.repository;

public interface WorkoutRepository {

    public Object clientWorkoutDiary(int clientID);
    public Object viewWorkout(int workoutID);

}
