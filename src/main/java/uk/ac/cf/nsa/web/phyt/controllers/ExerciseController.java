package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.repository.ExerciseRepositoryJDBC;

@Controller
public class ExerciseController {

    private ExerciseRepositoryJDBC exerciseRepo;

    @Autowired
    public ExerciseController(ExerciseRepositoryJDBC repo) {
        exerciseRepo = repo;
    }

    @RequestMapping(path="/trainer/exercises")
    public String trainerExercises(){

        return "exercises";
    }

     @RequestMapping(path = "/trainer/exercises/add", method = RequestMethod.POST)
    public ModelAndView trainerAddExercise(ExerciseForm exerciseForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
         if (!exerciseForm.validate()) {
             mav.addObject("message", "Please complete all of the exercise details.");
             mav.setViewName("CreateExercise");
         }
        else if (br.hasErrors()) {
            mav.addObject("message", "Exercise not submitted, please try again");
            mav.setViewName("CreateExercise");
        } else {
            if (exerciseRepo.addExercise(exerciseForm)) {
                mav.addObject("message", "Exercise successfully added");
                mav.setViewName("CreateExercise");
                } else {
                    mav.addObject("message", "Exercise not submitted, please try again");
                    mav.setViewName("CreateExercise");
                }
            }
        return mav;
    }
}


