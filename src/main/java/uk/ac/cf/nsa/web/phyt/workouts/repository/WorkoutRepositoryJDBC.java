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

    /*@Override
    public List<WorkoutDTO> clientWorkoutDiary(int clientID) {
        return (List<WorkoutDTO>) jdbcTemplate.query(
                "select id, client_id, exercise_length, exercise_rest, rep_rest, reps, thumbnail_id, completed, completed_at, created_at from Workouts where client_id=?",
                new WorkoutMapper(), clientID);
    }*/

    @Override
    public List<WorkoutDTO> clientWorkoutDiary(int clientID) {
        return (List<WorkoutDTO>) jdbcTemplate.query(
                "SELECT workouts.id, workouts.client_id, workouts.exercise_length, workouts.exercise_rest, workouts.rep_rest, workouts.reps, workouts.completed, workouts.completed_at, workouts.created_at, workouts.complete_by, media.img_src, media.alt_text, media.type FROM Workouts INNER JOIN Media ON Workouts.thumbnail_id=Media.id WHERE client_id=?",
                new WorkoutMapper(), clientID);
    }
}
