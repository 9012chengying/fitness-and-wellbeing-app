package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.repository.ExerciseRepositoryJDBC;

@Controller
@RequestMapping("/trainer/exercises")
public class ExerciseController {

    private ExerciseRepositoryJDBC exerciseRepo;

    @Autowired
    public ExerciseController(ExerciseRepositoryJDBC repo) {
        exerciseRepo = repo;
    }

    @GetMapping(path="/all")
    public String trainerExercises(){

        return "exercises";
    }

    @PostMapping(path = "/add")
    public ModelAndView trainerAddExercise(ExerciseForm exerciseForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
         if (!exerciseForm.validate()) {
             mav.addObject("message", exerciseForm.getCompleteMessage());
             mav.setViewName("CreateExercise");
         }
        else if (br.hasErrors()) {
            mav.addObject("message", "Exercise not submitted, please try again");
            mav.setViewName("CreateExercise");
        } else {
            if (exerciseRepo.addExercise(exerciseForm)) {
                mav.addObject("message", exerciseForm.getCompleteMessage());
                mav.setViewName("CreateExercise");
                } else {
                    mav.addObject("message", "Exercise not submitted, please try again");
                    mav.setViewName("CreateExercise");
                }
            }
        return mav;
    }

    @GetMapping(path="/add")
    public ModelAndView createExercise() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "");
        mav.setViewName("CreateExercise");
        return mav;
    }
}


