package uk.ac.cf.nsa.web.phyt.exercises.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Video;
import uk.ac.cf.nsa.web.phyt.exercises.data.mapper.ExerciseMapper;
import uk.ac.cf.nsa.web.phyt.exercises.data.mapper.ImageMapper;
import uk.ac.cf.nsa.web.phyt.exercises.data.mapper.VideoMapper;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

import java.util.List;

@Repository
public class ExerciseRepositoryJDBC implements ExerciseRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }


    public boolean addExercise(ExerciseForm exerciseForm){
        int rows = jdbcTemplate.update(
                "insert into Exercises(trainer_id, exercise_name,exercise_desc,category) values(?,?,?,?)" ,
                new Object[]{exerciseForm.getUserID(),exerciseForm.getExerciseName(), exerciseForm.getExerciseDesc(), exerciseForm.getExerciseCat()});
        System.out.println(rows>0);
        return rows>0;
    }


    public List<Exercise> getAllExercises(){
        return jdbcTemplate.query (
             "SELECT distinct exercises.id, exercises.exercise_name, exercises.exercise_desc, exercises.category, thumbnail_img, thumbnail_alt, exercises.created_at, (Select Count(media.id) from media where media.exercise_id=exercises.id AND type=\"Image\") as \"img_count\", \n" +
                     "(Select Count(media.id) from media where media.exercise_id=exercises.id AND type=\"Video\") as \"vid_count\"  FROM phyt.exercises \n" +
                     "LEFT JOIN Media\n" +
                     "ON exercises.id = Media.exercise_id order by exercises.created_at DESC;", new ExerciseMapper()
        );
    }

    @Override
    public List<Exercise> getExercisesByCategory(String exerciseCat){
        return jdbcTemplate.query(
                "SELECT DISTINCT exercises.id, exercises.exercise_name, exercises.exercise_desc, exercises.category, thumbnail_img, thumbnail_alt, exercises.created_at, (Select Count(media.id) from media where media.exercise_id=exercises.id AND type=\"Image\") as \"img_count\", \n" +
                        "(Select Count(media.id) from media where media.exercise_id=exercises.id AND type=\"Video\") as \"vid_count\" from phyt.exercises left join Media on exercises.id = Media.exercise_id where exercises.category= ? order by exercises.created_at DESC;", new ExerciseMapper(),  new Object[]{exerciseCat}
               );
    }


    public Exercise getExerciseByID(int id){
        Exercise exercise = (Exercise) jdbcTemplate.queryForObject("select distinct exercises.id, exercises.exercise_name, exercises.exercise_desc, exercises.category, thumbnail_img, thumbnail_alt, exercises.created_at, (Select Count(media.id) from media where media.exercise_id=exercises.id AND type=\"Image\") as \"img_count\", \n" +
                        "(Select Count(media.id) from media where media.exercise_id=exercises.id AND type=\"Video\") as \"vid_count\"  from phyt.exercises left join Media on exercises.id = Media.exercise_id where exercises.id= ?;",

                new ExerciseMapper(), new Object[]{id}
        );
        return exercise;
    }

    //Request to database to delete exercise by id
    public boolean deleteExercise(int id) {
        int row = jdbcTemplate.update("Delete FROM exercises WHERE exercises.id=?;", new Object[]{id});
        return row==1;
    }

    //Request to database to update an exercise by id
    public boolean updateExercise(ExerciseForm exerciseForm){
        int row = jdbcTemplate.update(
                "UPDATE Exercises SET exercise_name=? ,exercise_desc=? ,category=? WHERE id=?" ,
                new Object[]{exerciseForm.getExerciseName(), exerciseForm.getExerciseDesc(), exerciseForm.getExerciseCat(), exerciseForm.getExerciseID()});;
        return row > 0;
    }

    public boolean addImage(ExerciseForm exerciseForm){
        return false;
    }

    public boolean addVideo(ExerciseForm exerciseForm){
        return false;
    }


    public List<Image> getExerciseImages(int ID) throws DataAccessException {
        String sql = "SELECT id, img_src, alt_text, type, exercise_id FROM media WHERE exercise_id=? AND type='Image';";
        return jdbcTemplate.query(
                sql,new ImageMapper(), new Object[]{ID});
    }

    public List<Video> getExerciseVideos(int ID) throws DataAccessException {
        return jdbcTemplate.query(
                "SELECT id, img_src, alt_text, type, exercise_id FROM media WHERE exercise_id=? AND type='Video';", new VideoMapper(), new Object[]{ID}
        );
    }
}
