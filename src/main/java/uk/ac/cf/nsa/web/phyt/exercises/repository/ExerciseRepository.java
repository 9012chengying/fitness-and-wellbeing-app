package uk.ac.cf.nsa.web.phyt.exercises.repository;

import uk.ac.cf.nsa.web.phyt.exercises.DTO.ExerciseEntity;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

public interface ExerciseRepository {

    boolean addExercise(ExerciseForm exerciseForm);

    ExerciseEntity getAllExercises();

}
