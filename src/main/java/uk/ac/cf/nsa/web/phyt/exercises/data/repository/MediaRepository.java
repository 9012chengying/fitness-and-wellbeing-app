package uk.ac.cf.nsa.web.phyt.exercises.data.repository;

import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Video;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

import java.util.List;

public interface MediaRepository {

    boolean addImage(ExerciseForm exerciseForm);
    boolean addVideo(ExerciseForm exerciseForm);

    List<Image> getExerciseImages(int exercise_id);

    List<Video> getExerciseVideos(int exercise_id);

}
