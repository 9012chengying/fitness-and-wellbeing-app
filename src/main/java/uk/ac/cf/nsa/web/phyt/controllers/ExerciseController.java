package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

    @RequestMapping(path="/trainer/add-exercise")
    public String trainerAddExercise(){
        String message = "Add new exercise";
        return message;
    }
}
