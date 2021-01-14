package uk.ac.cf.nsa.web.phyt.workouts.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.WorkoutExercisesDTO;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.WorkoutSummaryDTO;
import uk.ac.cf.nsa.web.phyt.workouts.model.WorkoutSummaryMapper;
import uk.ac.cf.nsa.web.phyt.workouts.model.WorkoutExercisesMapper;

import java.util.List;

@Repository
public class WorkoutRepositoryJDBC implements WorkoutRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkoutRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    @Override
    public List<WorkoutSummaryDTO> clientWorkoutDiary(int clientID) {
        return (List<WorkoutSummaryDTO>) jdbcTemplate.query(
                "SELECT workouts.id, workouts.client_id, count(ExerciseWorkoutLink.exercise_id) as exercise_count, workouts.exercise_length, workouts.exercise_rest, " +
                        "workouts.rep_rest, workouts.reps, workouts.completed, date_format(workouts.completed_at, '%d/%m/%Y') AS completed_at, date_format(workouts.created_at, '%d/%m/%Y') AS created_at, date_format(workouts.complete_by, '%d/%m/%Y') AS complete_by, media.img_src, media.alt_text, " +
                        "media.type FROM Workouts INNER JOIN Media ON Workouts.thumbnail_id=Media.id INNER JOIN ExerciseWorkoutLink ON Workouts.id=ExerciseWorkoutLink.workout_id " +
                        "WHERE client_id=? GROUP BY workouts.id, workouts.client_id, workouts.exercise_length, workouts.exercise_rest, workouts.rep_rest, workouts.reps, " +
                        "workouts.completed, workouts.completed_at, workouts.created_at, workouts.complete_by, media.img_src, media.alt_text, media.type ORDER BY workouts.created_at DESC",
                new WorkoutSummaryMapper(), clientID);
    }

    public List<WorkoutExercisesDTO> viewWorkout(int workoutID) {
        return (List<WorkoutExercisesDTO>) jdbcTemplate.query(
                "SELECT workouts.id AS workout_id, workouts.client_id, workouts.exercise_length, workouts.exercise_rest, workouts.rep_rest, workouts.reps, workouts.created_at, workouts.complete_by, workouts.completed_at, exercises.id AS exercise_id, exercises.exercise_name, exercises.category, exercises.equipment, exercises.thumbnail_id FROM ExerciseWorkoutLink RIGHT JOIN Workouts ON ExerciseWorkoutLink.workout_id=workouts.id LEFT JOIN Exercises ON ExerciseWorkoutLink.exercise_id=exercises.id WHERE workout_id=?;",
                new WorkoutExercisesMapper(), workoutID);
    }
}
