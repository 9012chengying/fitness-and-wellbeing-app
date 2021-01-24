package uk.ac.cf.nsa.web.phyt.trainer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.client.DTO.WorkoutDTO;
import uk.ac.cf.nsa.web.phyt.trainer.DTO.ClientDTO;
import uk.ac.cf.nsa.web.phyt.trainer.DTO.TrainerWorkoutDTO;
import uk.ac.cf.nsa.web.phyt.trainer.forms.WorkoutDetailsForm;
import uk.ac.cf.nsa.web.phyt.trainer.forms.WorkoutExercisesForm;
import uk.ac.cf.nsa.web.phyt.trainer.model.ClientMapper;
import uk.ac.cf.nsa.web.phyt.trainer.model.TrainerWorkoutMapper;

import java.util.List;

@Repository
public class TrainerWorkoutRepositoryJDBC implements TrainerWorkoutRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TrainerWorkoutRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean addWorkout(WorkoutDetailsForm workoutDetailsForm) {
        int rows = jdbcTemplate.update(
                "INSERT INTO Workouts (client_id, exercise_length, exercise_rest, rep_rest, reps, equipment, complete_by) VALUES (?, ?, ?, ?, ?, ?, ?)",
                new Object[]{workoutDetailsForm.getClientID(), workoutDetailsForm.getExerciseLength(), workoutDetailsForm.getExerciseRest(), workoutDetailsForm.getRepRest(), workoutDetailsForm.getReps(), workoutDetailsForm.getEquipment(), workoutDetailsForm.getDueDate()});
        return rows > 0;
    }

    @Override
    public List<ClientDTO> clientUsernameByTrainerID(int trainerID) {
        return (List<ClientDTO>) jdbcTemplate.query(
                "SELECT trainer_id, id, user_name FROM user WHERE trainer_id=?",
                new ClientMapper(), trainerID);
    }

    @Override
    public List<TrainerWorkoutDTO> allWorkouts(int trainerID) {
        return (List<TrainerWorkoutDTO>) jdbcTemplate.query(
                "SELECT workouts.id, workouts.client_id, workouts.thumbnail_id, date_format(workouts.complete_by, '%d-%b-%y') AS complete_by, workouts.completed, date_format(workouts.completed_at, '%d-%b-%y') AS completed_at, date_format(workouts.created_at, '%d-%b-%y') AS created_at, COUNT(ExerciseWorkoutLink.exercise_id) as exercise_count, user.trainer_id, user.user_name, media.img_src, media.alt_text FROM workouts INNER JOIN user ON workouts.client_id=user.id LEFT JOIN ExerciseWorkoutLink ON workouts.id=ExerciseWorkoutLink.workout_id LEFT JOIN media ON workouts.thumbnail_id=media.id WHERE user.trainer_id=? GROUP BY workouts.id, workouts.client_id, workouts.thumbnail_id, workouts.complete_by, workouts.completed, workouts.completed_at, workouts.created_at, user.trainer_id, user.user_name, media.img_src ORDER BY workouts.created_at DESC",
                new TrainerWorkoutMapper(), trainerID);
    }

    @Override
    public boolean addExercise(WorkoutExercisesForm workoutExercisesForm) {
        int rows = 0;
        for (int i = 0; i < workoutExercisesForm.getExerciseID().size(); i++) {
            rows = jdbcTemplate.update(
                    "INSERT INTO ExerciseWorkoutLink (workout_id, exercise_id) VALUES (?, ?)",
                    new Object[]{workoutExercisesForm.getWorkoutID(), workoutExercisesForm.getExerciseID().get(i)});

        }
        return rows > 0;
    }
}