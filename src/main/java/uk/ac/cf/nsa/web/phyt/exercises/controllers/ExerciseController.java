package uk.ac.cf.nsa.web.phyt.exercises.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.repository.ExerciseRepositoryJDBC;

@Controller
@RequestMapping("/trainer/exercises")
public class ExerciseController {

    private ExerciseRepositoryJDBC exerciseRepo;

    @Autowired
    public ExerciseController(ExerciseRepositoryJDBC repo) {
        exerciseRepo = repo;
    }


    @GetMapping(path="/add")
    public ModelAndView createExercise() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", false);
        mav.setViewName("CreateExercise");
        return mav;
    }

    @PostMapping(path = "/add")
    public ModelAndView trainerAddExercise(ExerciseForm exerciseForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
         if (!exerciseForm.validate()) {
             mav.addObject("message", exerciseForm);
             mav.setViewName("CreateExercise");
         }
        else if (br.hasErrors()) {
            mav.addObject("message", exerciseForm);
            mav.setViewName("CreateExercise");
        } else {
            if (exerciseRepo.addExercise(exerciseForm)) {
                mav.setViewName("AllExercises");
                } else {
                    mav.addObject("message", exerciseForm);
                    mav.setViewName("CreateExercise");
                }
            }
        return mav;
    }

}


