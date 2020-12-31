package uk.ac.cf.nsa.web.phyt.exercises.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.exercises.DTO.ImageEntity;
import uk.ac.cf.nsa.web.phyt.exercises.DTO.VideoEntity;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.model.ImageMapper;
import uk.ac.cf.nsa.web.phyt.exercises.model.VideoMapper;

import java.util.List;

@Repository
public class MediaRespositoryJDBC implements MediaRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MediaRespositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }


    public boolean addImage(ExerciseForm exerciseForm){
        return false;
    }

    public boolean addVideo(ExerciseForm exerciseForm){
        return false;
    }


    public List<ImageEntity> getExerciseImages(int ID){
        String sql = "SELECT id, img_src, alt_text, type, exercise_id FROM media WHERE exercise_id=? AND type='Image';";
        return jdbcTemplate.query(
                sql, new Object[]{ID}, new ImageMapper()
        );
    }

    public List<VideoEntity> getExerciseVideos(int ID){
        return jdbcTemplate.query(
                "SELECT id, img_src, alt_text, type, exercise_id FROM media WHERE exercise_id=? AND type='Video';", new Object[]{ID}, new VideoMapper()
        );
    }
}
