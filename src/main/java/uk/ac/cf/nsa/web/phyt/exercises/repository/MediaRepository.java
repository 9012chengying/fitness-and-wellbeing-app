package uk.ac.cf.nsa.web.phyt.exercises.repository;

import uk.ac.cf.nsa.web.phyt.exercises.DTO.ImageEntity;
import uk.ac.cf.nsa.web.phyt.exercises.DTO.VideoEntity;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

import java.util.List;

public interface MediaRepository {

    boolean addImage(ExerciseForm exerciseForm);
    boolean addVideo(ExerciseForm exerciseForm);

    List<ImageEntity> getExerciseImages(int exercise_id);

    List<VideoEntity> getExerciseVideos(int exercise_id);

}
