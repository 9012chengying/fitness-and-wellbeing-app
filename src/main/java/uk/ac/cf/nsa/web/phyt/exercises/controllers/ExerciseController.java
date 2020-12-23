package uk.ac.cf.nsa.web.phyt.exercises.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.repository.ExerciseRepository;
import uk.ac.cf.nsa.web.phyt.exercises.repository.UserRepository;


@Controller
public class ExerciseController {

    private ExerciseRepository exerciseRepo;
    private UserRepository userRepo;

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepo, UserRepository userRepo) {
        this.exerciseRepo = exerciseRepo;
        this.userRepo = userRepo;
    }


    @RequestMapping(path = "/trainer/exercises/add", method= RequestMethod.POST)
    public ModelAndView trainerAddExercise (ExerciseForm exerciseForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            System.out.println(br.toString());
            mav.setViewName("CreateExercise");
            return mav;
        } else {
            exerciseRepo.addExercise((exerciseForm));
            mav.setViewName("CreateExercise");
            return mav;
        }
    }

//    @RequestMapping(path="/login", method= RequestMethod.GET)
//    public ModelAndView showCreateExercise(@RequestParam(value="username", defaultValue="null") String username,
//                                           @RequestParam(value="password", defaultValue="null") String password) {
//        System.out.println(username + " " + password);
//        ModelAndView mav = new ModelAndView();
//        System.out.println(username + " " + password);
//        if (userRepo.getUserRole(username, password) == "Trainer") {
//            mav.setViewName("CreateExercise");
//            return mav;
//        } else {
//            mav.setViewName("index");
//            return mav;
//        }
//    }

    @RequestMapping(path="/trainer/exercises/add", method= RequestMethod.GET)
    public ModelAndView createExercise() {
        ModelAndView mav = new ModelAndView();
        //if (userRepo.getUserRole(username, password) == "Trainer") {
            mav.setViewName("CreateExercise");
            return mav;
        //} else {
          //  mav.setViewName("index");
          //  return "redirect: index";
     // }
    }



}


