package uk.ac.cf.nsa.web.phyt.exercises.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.exercises.DTO.ExerciseEntity;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.model.ExerciseMapper;

import java.util.List;

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
                new Object[]{exerciseForm.getUserID(),exerciseForm.getExerciseName(), exerciseForm.getExerciseDesc(), exerciseForm.getExerciseCat()});
        return rows>0;
    }


    public List<ExerciseEntity> getAllExercises(){
        return jdbcTemplate.query (
             "SELECT exercises.id, exercises.exercise_name, exercises.exercise_desc, exercises.category, media.img_src, media.alt_text  FROM phyt.exercises \n" +
                     "LEFT JOIN Media\n" +
                     "ON exercises.thumbnail_id = Media.id;", new ExerciseMapper()
        );
    }

    public List<ExerciseEntity> filterExercises(String exerciseCat){
        System.out.println(exerciseCat);
        return jdbcTemplate.queryForList(
                "select exercises.id, exercises.exercise_name, exercises.exercise_desc, exercises.category, media.img_src, media.alt_text from phyt.exercises left join Media on exercises.thumbnail_id = Media.id where exercises.category= ?", new Object[]{exerciseCat}, new List<ExerciseEntity> , new ExerciseMapper()
        );
    }
}
