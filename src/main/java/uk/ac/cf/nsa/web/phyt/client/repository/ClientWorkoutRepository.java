package uk.ac.cf.nsa.web.phyt.client.repository;

import java.util.List;

public interface ClientWorkoutRepository {

    public Object clientWorkoutDiary(int clientID);
    public Object workoutOverview(int workoutID);
    public Object workoutExerciseDetails(int workoutID);
    public String workoutCategories(int workoutID);
    public int findIncompleteWorkoutID(int clientID);
    public Object viewExerciseByID(int exerciseID);
    public Object mediaByExerciseID(int exerciseID);
    public List<String> exerciseNameByWorkoutID(int workoutID);
    public List<String> exerciseThumbnailByWorkoutID(int workoutID);

}
