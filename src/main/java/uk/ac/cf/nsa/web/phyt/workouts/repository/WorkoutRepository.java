package uk.ac.cf.nsa.web.phyt.workouts.repository;

public interface WorkoutRepository {

    public Object clientWorkoutDiary(int clientID);
    public Object workoutOverview(int workoutID);
    public Object workoutExerciseDetails(int workoutID);
    public int findIncompleteWorkoutID(int clientID);
    public Object viewExerciseByID(int exerciseID);
    public Object mediaByExerciseID(int exerciseID);

}
