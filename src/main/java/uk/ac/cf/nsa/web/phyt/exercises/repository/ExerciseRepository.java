package uk.ac.cf.nsa.web.phyt.exercises.repository;

import uk.ac.cf.nsa.web.phyt.exercises.DTO.ExerciseEntity;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface ExerciseRepository {

    boolean addExercise(ExerciseForm exerciseForm);

    List<ExerciseEntity> getAllExercises();

    List<ExerciseEntity> filterExercises(String exerciseCat);

    ExerciseEntity viewExercise(int id);
}
