package uk.ac.cf.nsa.web.phyt.exercises.data.repository;

import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Video;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

import java.util.List;

public interface ExerciseRepository {

    boolean addExercise(ExerciseForm exerciseForm);

    List<Exercise> getAllExercises(int userID);

    List<Exercise> getExercisesByCategory(String exerciseCat, int userID);

    Exercise getExerciseByID(int id);

    boolean updateExercise(ExerciseForm exerciseForm);

    boolean deleteExercise(int id);

    boolean updateVideo(ExerciseForm exerciseForm);

    boolean addVideo(ExerciseForm exerciseForm);

    boolean addVideoWithExerciseID(ExerciseForm exerciseForm);

    List<Image> getExerciseImages(int exercise_id);

    List<Video> getExerciseVideos(int exercise_id);
}
