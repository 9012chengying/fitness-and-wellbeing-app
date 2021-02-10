//package uk.ac.cf.nsa.web.phyt.exercises.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import uk.ac.cf.nsa.web.phyt.exercises.service.ExerciseManagementService;
//
//@RestController
//@RequestMapping(path ="/trainer/exercises")
//public class ExerciseRestController {
//
//    //Use ExerciseManagementService methods to manage exercise data
//    private final ExerciseManagementService exerciseService;
//
//    @Autowired
//    public ExerciseRestController(ExerciseManagementService exerciseService) {
//        this.exerciseService = exerciseService;
//    }
//
//    //Delete an exercise from database
//    @DeleteMapping(path="/delete/{exerciseID}")
//    public String deleteExercise(@PathVariable String exerciseID) {
//
//        //Returns either a success or failed message String
//        return exerciseService.deleteExercise(exerciseID);
//    }
//}