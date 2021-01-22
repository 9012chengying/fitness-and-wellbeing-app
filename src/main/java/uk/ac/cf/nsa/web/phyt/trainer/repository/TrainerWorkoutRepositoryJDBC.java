package uk.ac.cf.nsa.web.phyt.trainer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.trainer.DTO.ClientDTO;
import uk.ac.cf.nsa.web.phyt.trainer.forms.WorkoutDetailsForm;
import uk.ac.cf.nsa.web.phyt.trainer.mapper.ClientMapper;

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
}