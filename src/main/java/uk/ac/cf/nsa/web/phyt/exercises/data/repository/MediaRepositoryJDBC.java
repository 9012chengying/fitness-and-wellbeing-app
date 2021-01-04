package uk.ac.cf.nsa.web.phyt.exercises.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Video;
import uk.ac.cf.nsa.web.phyt.exercises.data.mapper.VideoMapper;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;
import uk.ac.cf.nsa.web.phyt.exercises.data.mapper.ImageMapper;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

import java.util.List;

@Repository
public class MediaRepositoryJDBC implements MediaRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MediaRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }


    public boolean addImage(ExerciseForm exerciseForm){
        return false;
    }

    public boolean addVideo(ExerciseForm exerciseForm){
        return false;
    }


    public List<Image> getExerciseImages(int ID){
        String sql = "SELECT id, img_src, alt_text, type, exercise_id FROM media WHERE exercise_id=? AND type='Image';";
        return jdbcTemplate.query(
                sql, new Object[]{ID}, new ImageMapper()
        );
    }

    public List<Video> getExerciseVideos(int ID){
        return jdbcTemplate.query(
                "SELECT id, img_src, alt_text, type, exercise_id FROM media WHERE exercise_id=? AND type='Video';", new Object[]{ID}, new VideoMapper()
        );
    }
}
