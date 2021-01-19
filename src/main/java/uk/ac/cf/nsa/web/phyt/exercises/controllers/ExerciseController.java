package uk.ac.cf.nsa.web.phyt.exercises.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.service.ExerciseManagementService;
//import uk.ac.cf.nsa.web.phyt.users.service.UserService;


@Controller
@RequestMapping(path ="/trainer/exercises")

public class ExerciseController {

    //Use ExerciseManagementService methods to access appropriate data
    private final ExerciseManagementService exerciseService;
    //private final UserService userService;

    @Autowired
    public ExerciseController(ExerciseManagementService exerciseService) {
        this.exerciseService = exerciseService;
        //this.userService = userService;
    }

    //List all exercises
    @GetMapping(path = "/all")

    public ModelAndView allExercises() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exercises", exerciseService.listAllExercises());
        mav.setViewName("AllExercises");
        return mav;
    }

    //Filter exercises by category
    @GetMapping(path = "/filter")
    public ModelAndView filterExercises(@RequestParam(value = "categoryFilter", defaultValue = "All") String exerciseCat) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exercises", exerciseService.listExercisesByCategory(exerciseCat));
        mav.setViewName("AllExercises");
        return mav;
    }

    //View an individual exercise
    @GetMapping(path = "/view")
    public ModelAndView getExercise(@RequestParam(value = "exerciseID", defaultValue = "") String exerciseID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exercise", exerciseService.viewExercise(exerciseID));
        mav.addObject("images", exerciseService.viewExercise(exerciseID).getImages());
        mav.addObject("videos", exerciseService.viewExercise(exerciseID).getVideos());
        mav.setViewName("ViewExercise");
        return mav;
    }

    //Show 'Create Exercise' Form
    @GetMapping(path = "/add")
    public ModelAndView createExercise() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("CreateExercise");
        return mav;
    }

    //Create new exercise in database
    @PostMapping(path = "/add")
    public String trainerAddExercise(ExerciseForm exerciseForm, BindingResult br) {
        if (br.hasErrors()) {
            System.out.println(br.toString());
            return br.toString();
        } else {
            if (exerciseService.createNewExercise(exerciseForm)) {
                return "redirect:all";
            } else {
                return "redirect:add";
            }
        }
    }

    @GetMapping(path = "/edit")
    public ModelAndView getEditExercise(@RequestParam(value = "exerciseID", defaultValue = "") String exerciseID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exercise", exerciseService.viewExercise(exerciseID));
        mav.setViewName("EditExercise");
        return mav;
    }

    @PostMapping(path="/edit")
    public  ModelAndView updateExercise(ExerciseForm exerciseForm, BindingResult br){
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            System.out.println(br.toString());
            mav.setViewName("EditExercise");
            return mav;
        } else {
            mav.addObject("exercise",exerciseService.editExercise(exerciseForm));
            mav.setViewName("ViewExercise");
            return mav;
        }
    }

    //Delete an exercise from database
    @GetMapping(path = "/delete")
    public String deleteExercise(@RequestParam(value = "exerciseID", defaultValue = "") String exerciseID) {

        //todo ExerciseManagementService to delete an exercise
        System.out.println("Exercise " + exerciseID + " will be deleted");

        return "redirect:all";
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

}



