package uk.ac.cf.nsa.web.phyt.exercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Video;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.ExerciseRepository;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ExerciseManagementService {

    private final ExerciseRepository exerciseRepo;

    @Autowired
    public ExerciseManagementService(ExerciseRepository exerciseR) {
        this.exerciseRepo = exerciseR;
    }

    //Add new exercise
    public boolean createNewExercise(ExerciseForm exerciseForm) {
        return exerciseRepo.addExercise(exerciseForm);
    }

    //Return a list of all exercises for a Trainer
    public List<Exercise> listAllExercises() {
        List<Exercise> allExercises = exerciseRepo.getAllExercises();

        for (int i=0; i<allExercises.size(); i++){
            Exercise exercise = allExercises.get(i);
            Timestamp createdDate = exercise.getCreatedDate();
            exercise.dateConverter(createdDate);
        }
        return allExercises;
    }

    //Return list of exercises based on category
    public List<Exercise> listExercisesByCategory(String exerciseCat) {
        //if category selection is ALL then return list of all exercises otherwise filter
        if (exerciseCat.equals("All")) {
            return listAllExercises();
        } else {
            List<Exercise> allExercises = exerciseRepo.getExercisesByCategory(exerciseCat);
            for (int i=0; i<allExercises.size(); i++){
                Exercise exercise = allExercises.get(i);
                Timestamp createdDate = exercise.getCreatedDate();
                exercise.dateConverter(createdDate);
            }
            return allExercises;
        }
    }

    //Return a specific exercise
    public Exercise viewExercise(String exerciseID) {

        //parse exerciseID String to an integer to use in repo query.
        int ID = Integer.parseInt(exerciseID);

        //Create image and video lists for exercise
        List<Image> exerciseImages = exerciseRepo.getExerciseImages(ID);
        List<Video> exerciseVideos = exerciseRepo.getExerciseVideos(ID);

        //Create exercise object and add image & video lists
        Exercise selectedExercise = exerciseRepo.getExerciseByID(ID);
        selectedExercise.setVideos(exerciseVideos);
        selectedExercise.setImages(exerciseImages);

        return selectedExercise;
    }


    public String deleteExercise(String exerciseID) {

        //parse exerciseID String to an integer to use in repo query.
        int ID = Integer.parseInt(exerciseID);

        //get result from repository query
        boolean result = exerciseRepo.deleteExercise(ID);
        if(!result) {
            return  "failed";
        } else {
            return  "success";
        }
    }

    //Add a new image to an exercise
    public boolean addNewImage(Image image) {

        //TODO complete method to add new image
        return false;
    }


}
