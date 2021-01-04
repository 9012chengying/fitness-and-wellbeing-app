package uk.ac.cf.nsa.web.phyt.exercises.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.data.mapper.ExerciseMapper;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.ExerciseRepository;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

import java.util.List;

@Repository
public class ExerciseRepositoryJDBC implements ExerciseRepository {

    private JdbcTemplate jdbcTemplate;
    private Object List;

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


    public List<Exercise> getAllExercises(){
        return jdbcTemplate.query (
             "SELECT exercises.id, exercises.exercise_name, exercises.exercise_desc, exercises.category, media.img_src, media.alt_text  FROM phyt.exercises \n" +
                     "LEFT JOIN Media\n" +
                     "ON exercises.thumbnail_id = Media.id order by exercises.created_at DESC;", new ExerciseMapper()
        );
    }

    @Override
    public List<Exercise> getExercisesByCategory(String exerciseCat){
        return jdbcTemplate.query(
                "select exercises.id, exercises.exercise_name, exercises.exercise_desc, exercises.category, media.img_src, media.alt_text from phyt.exercises left join Media on exercises.thumbnail_id = Media.id where exercises.category= ? order by exercises.created_at DESC;", new Object[]{exerciseCat}, new ExerciseMapper()
               );
    }


    public Exercise getExerciseByID(int id){
        Exercise exercise = (Exercise) jdbcTemplate.queryForObject("select exercises.id, exercises.exercise_name, exercises.exercise_desc, exercises.category, media.img_src, media.alt_text from phyt.exercises left join Media on exercises.thumbnail_id = Media.id where exercises.id= ?;",
                new Object[]{id},
                new ExerciseMapper()
        );
        return exercise;
    }
}
