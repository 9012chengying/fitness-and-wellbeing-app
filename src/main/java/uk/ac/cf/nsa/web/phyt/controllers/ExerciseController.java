package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExerciseController {

    @RequestMapping(path="/trainer/exercises")
    public String trainerExercises(){
        return "exercises";
    }

    @RequestMapping(path="/trainer/exercises/add")
    public String trainerAddExercise(){
        return "CreateExercise";
    }
}
