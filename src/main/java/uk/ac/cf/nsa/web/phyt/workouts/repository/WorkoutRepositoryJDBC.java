package uk.ac.cf.nsa.web.phyt.workouts.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.*;
import uk.ac.cf.nsa.web.phyt.workouts.model.*;

import java.util.List;

@Repository
public class WorkoutRepositoryJDBC implements WorkoutRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkoutRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    //query for client diary page
    @Override
    public List<WorkoutDTO> clientWorkoutDiary(int clientID) { //need to change so that workout thumbnail is in workout table
        return (List<WorkoutDTO>) jdbcTemplate.query(
                "SELECT workouts.id, workouts.client_id, count(ExerciseWorkoutLink.exercise_id) as exercise_count, workouts.exercise_length, workouts.exercise_rest, " +
                        "workouts.rep_rest, workouts.reps, workouts.equipment, workouts.completed, date_format(workouts.completed_at, '%H:%i %d-%b-%y') AS completed_at, date_format(workouts.created_at, '%d-%b-%y') " +
                        "AS created_at, date_format(workouts.complete_by, '%d-%b-%y') AS complete_by, media.img_src, media.alt_text, media.type FROM Workouts INNER JOIN Media ON " +
                        "Workouts.thumbnail_id=Media.id INNER JOIN ExerciseWorkoutLink ON Workouts.id=ExerciseWorkoutLink.workout_id WHERE client_id=? GROUP BY workouts.id, workouts.client_id, " +
                        "workouts.exercise_length, workouts.exercise_rest, workouts.rep_rest, workouts.reps, workouts.equipment, workouts.completed, workouts.completed_at, workouts.created_at, workouts.complete_by, " +
                        "media.img_src, media.alt_text, media.type ORDER BY workouts.created_at DESC",
                new WorkoutMapper(), clientID);
    }

    //queries for client workout preview page
    @Override
    public WorkoutDTO newWorkout(int workoutID) {
        WorkoutDTO workoutDTO = (WorkoutDTO) jdbcTemplate.queryForObject( //need to change so that workout thumbnail is in workout table
                "SELECT workouts.id, workouts.client_id, count(ExerciseWorkoutLink.exercise_id) as exercise_count, workouts.exercise_length, workouts.exercise_rest, " +
                        "workouts.rep_rest, workouts.reps, workouts.equipment, workouts.completed, date_format(workouts.completed_at, '%H:%i %d-%b-%y') AS completed_at, date_format(workouts.created_at, '%d-%b-%y') " +
                        "AS created_at, date_format(workouts.complete_by, '%d-%b-%y') AS complete_by, media.img_src, media.alt_text, media.type FROM Workouts INNER JOIN Media ON " +
                        "Workouts.thumbnail_id=Media.id INNER JOIN ExerciseWorkoutLink ON Workouts.id=ExerciseWorkoutLink.workout_id WHERE workouts.id=? GROUP BY workouts.id, workouts.client_id, " +
                        "workouts.exercise_length, workouts.exercise_rest, workouts.rep_rest, workouts.reps, workouts.equipment, workouts.completed, workouts.completed_at, workouts.created_at, workouts.complete_by, " +
                        "media.img_src, media.alt_text, media.type",
                new WorkoutMapper(), workoutID);
        return workoutDTO;
    }

    @Override
    public List<ExerciseWorkoutDTO> newWorkoutDetails(int workoutID) {
        return (List<ExerciseWorkoutDTO>) jdbcTemplate.query(
                "SELECT ExerciseWorkoutLink.workout_id, exercises.id AS exercise_id, exercises.exercise_name, exercises.category, exercises.equipment, exercises.thumbnail_img, exercises.thumbnail_alt " +
                        "FROM Exercises INNER JOIN ExerciseWorkoutLink ON Exercises.id=ExerciseWorkoutLink.exercise_id WHERE workout_id=?",
                new ExerciseWorkoutMapper(), workoutID);
    }

    //query for discovering workoutID for client's oldest incomplete workout
    @Override
    public int findIncompleteWorkoutID(int clientID) {
        WorkoutIDDTO workoutIDDTO = (WorkoutIDDTO) jdbcTemplate.queryForObject(
                "SELECT id, client_id, completed FROM Workouts WHERE client_id=? AND completed=false ORDER BY created_at LIMIT 1",
                new WorkoutIDMapper(), clientID);
        if (workoutIDDTO == null) { //this doesn't work - NEED TO FIX
            return -1;
        } else {
            return workoutIDDTO.getWorkoutID();
        }
    }

    @Override
    public ExerciseDTO viewExerciseByID(int exerciseID) {
        ExerciseDTO exerciseDTO = (ExerciseDTO) jdbcTemplate.queryForObject(
                "SELECT id, exercise_name, exercise_desc, category, equipment FROM exercises WHERE id=?",
                new ExerciseMapper(), exerciseID);
        return exerciseDTO;
    }

    @Override
    public List<ExerciseMediaDTO> mediaByExerciseID(int exerciseID) {
        return (List<ExerciseMediaDTO>) jdbcTemplate.query(
                "SELECT media.exercise_id, media.type, media.img_src, media.alt_text FROM media INNER JOIN exercises on exercises.id=media.exercise_id WHERE exercise_id=?",
                new ExerciseMediaMapper(), exerciseID);
    }

}