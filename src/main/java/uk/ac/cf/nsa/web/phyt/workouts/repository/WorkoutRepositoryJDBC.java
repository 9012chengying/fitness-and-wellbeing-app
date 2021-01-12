package uk.ac.cf.nsa.web.phyt.workouts.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.workouts.DTO.WorkoutDTO;
import uk.ac.cf.nsa.web.phyt.workouts.model.WorkoutMapper;

import java.util.List;

@Repository
public class WorkoutRepositoryJDBC implements WorkoutRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkoutRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    @Override
    public List<WorkoutDTO> clientWorkoutDiary(int clientID) {
        return (List<WorkoutDTO>) jdbcTemplate.query(
                "select id, client_id, exercise_length, exercise_rest, rep_rest, reps, completed, completed_at, created_at from Workouts where client_id=?",
                new WorkoutMapper(), clientID);
    }
}
