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
                "INSERT INTO Workouts (client_id, exercise_length, exercise_rest, rep_rest, reps, complete_by) VALUES (?, ?, ?, ?, ?, ?)",
                new Object[]{workoutDetailsForm.getClientID(), workoutDetailsForm.getExerciseLength(), workoutDetailsForm.getExerciseRest(), workoutDetailsForm.getRepRest(),
                        workoutDetailsForm.getReps(), workoutDetailsForm.getDueDate()});
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
                "SELECT workouts.id, workouts.client_id, workouts.thumbnail_img, date_format(workouts.complete_by, '%d-%b-%y') AS complete_by, workouts.completed, " +
                        "date_format(workouts.completed_at, '%d-%b-%y') AS completed_at, date_format(workouts.created_at, '%d-%b-%y') AS created_at, COUNT(ExerciseWorkoutLink.exercise_id) " +
                        "as exercise_count, user.trainer_id, user.user_name FROM workouts INNER JOIN user ON workouts.client_id=user.id LEFT JOIN " +
                        "ExerciseWorkoutLink ON workouts.id=ExerciseWorkoutLink.workout_id WHERE user.trainer_id=? GROUP BY " +
                        "workouts.id, workouts.client_id, workouts.thumbnail_img, workouts.complete_by, workouts.completed, workouts.completed_at, workouts.created_at, user.trainer_id, " +
                        "user.user_name ORDER BY workouts.created_at DESC",
                new TrainerWorkoutMapper(), trainerID);
    }

    @Override
    public boolean addExercise(WorkoutExercisesForm workoutExercisesForm) {
        System.out.println(workoutExercisesForm.getWorkoutThumbnail());
        int rowsE = 0;
        for (int i = 0; i < workoutExercisesForm.getExerciseID().size(); i++) {
            rowsE = jdbcTemplate.update(
                    "INSERT INTO ExerciseWorkoutLink (workout_id, exercise_id) VALUES (?, ?)",
                    new Object[]{workoutExercisesForm.getWorkoutID(), workoutExercisesForm.getExerciseID().get(i)});

        }
        int rowsW = jdbcTemplate.update(
                "UPDATE workouts SET equipment=?, thumbnail_img=? WHERE id=?",
                new Object[]{workoutExercisesForm.getEquipment(), workoutExercisesForm.getWorkoutThumbnail(), workoutExercisesForm.getWorkoutID()});
        return rowsE > 0 && rowsW > 0;
    }

}