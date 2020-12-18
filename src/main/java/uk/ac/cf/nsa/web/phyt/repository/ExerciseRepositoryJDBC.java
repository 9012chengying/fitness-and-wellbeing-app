package uk.ac.cf.nsa.web.phyt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.forms.ExerciseForm;

@Repository
public class ExerciseRepositoryJDBC implements ExerciseRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }


    public boolean addExercise(ExerciseForm exerciseForm){
        int rows = jdbcTemplate.update(
                "insert into Exercises(trainer_id, exercise_name,exercise_desc,category) values(?,?,?,?)" ,
                new Object[]{exerciseForm.getTrainerID(),exerciseForm.getExerciseName(), exerciseForm.getExerciseDesc(), exerciseForm.getExerciseCat()});
        return rows>0;
    };
}
