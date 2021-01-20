package uk.ac.cf.nsa.web.phyt.workouts.repository;

import java.util.List;

public interface WorkoutRepository {

    public Object clientWorkoutDiary(int clientID);
    public Object workoutOverview(int workoutID);
    public Object workoutExerciseDetails(int workoutID);
    public int findIncompleteWorkoutID(int clientID);
    public Object viewExerciseByID(int exerciseID);
    public Object mediaByExerciseID(int exerciseID);
    public List<String> exerciseNameByWorkoutID(int workoutID);
    public List<String> exerciseThumbnailByWorkoutID(int workoutID);

}
