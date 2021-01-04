package uk.ac.cf.nsa.web.phyt.exercises.data.repository;

import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

import java.util.List;

public interface ExerciseRepository {

    boolean addExercise(ExerciseForm exerciseForm);

    List<Exercise> getAllExercises();

    List<Exercise> getExercisesByCategory(String exerciseCat);

    Exercise getExerciseByID(int id);
}
