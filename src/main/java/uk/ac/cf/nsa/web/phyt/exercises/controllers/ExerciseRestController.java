package uk.ac.cf.nsa.web.phyt.exercises.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.repository.ExerciseRepository;
import uk.ac.cf.nsa.web.phyt.exercises.repository.UserRepository;

@RestController
public class ExerciseRestController {

    private ExerciseRepository exerciseRepo;
    private UserRepository userRepo;

    @Autowired
    public ExerciseRestController(ExerciseRepository exerciseRepo, UserRepository userRepo) {
        this.exerciseRepo = exerciseRepo;
        this.userRepo = userRepo;
    }


}

