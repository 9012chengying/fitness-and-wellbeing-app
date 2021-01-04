package uk.ac.cf.nsa.web.phyt.exercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Video;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.ExerciseRepository;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.MediaRepository;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

import java.util.List;

@Service
public class ExerciseManagementService {

    private ExerciseRepository exerciseRepo;
    private MediaRepository mediaRepo;

    @Autowired
    public ExerciseManagementService(ExerciseRepository exerciseRepo, MediaRepository mediaR) {
        this.exerciseRepo = exerciseRepo;
        this.mediaRepo = mediaR;
    }

    //Add new exercise
    public boolean createNewExercise(ExerciseForm exerciseForm){
        return exerciseRepo.addExercise(exerciseForm);
    }

    //Return a list of all exercises for a Trainer
    public List<Exercise> listAllExercises(){
        return exerciseRepo.getAllExercises();
    }

    //Return list of exercises based on category
    public List<Exercise> getExerciseByCategory(String exerciseCat) {
        //if category selection is ALL then return list of all exercises otherwise filter
        if(exerciseCat.equals("All")){
          return listAllExercises();
        } else {
           return exerciseRepo.getExercisesByCategory(exerciseCat);
        }
    }

    //Return a specific exercise
    public Exercise viewExercise (String exerciseID){
        //parse exerciseID String to an integer to use in repo query.
        int ID = Integer.parseInt(exerciseID);
        //set image and video lists from media repo
        List<Image> exerciseImages = mediaRepo.getExerciseImages(ID);
        List<Video> exerciseVideos= mediaRepo.getExerciseVideos(ID);
        //set exercise and add image & video lists
        Exercise selectedExercise = exerciseRepo.getExerciseByID(ID);
        selectedExercise.setVideos(exerciseVideos);
        selectedExercise.setImages(exerciseImages);
        return selectedExercise;
    }
}
