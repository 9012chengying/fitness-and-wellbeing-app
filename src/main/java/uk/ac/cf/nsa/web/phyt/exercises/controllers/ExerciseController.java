package uk.ac.cf.nsa.web.phyt.exercises.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.repository.ExerciseRepository;

import static java.lang.Integer.parseInt;
//import uk.ac.cf.nsa.web.phyt.exercises.repository.UserRepository;


@Controller
public class ExerciseController {

    private ExerciseRepository exerciseRepo;
    //private UserRepository userRepo;

    @Autowired
    public ExerciseController(ExerciseRepository exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
        //this.userRepo = userRepo;
    }

    //TODO add object attribute to get exercises to populate template
    @RequestMapping (path="/trainer/exercises/all", method=RequestMethod.GET)
    public ModelAndView allExercises(){
        ModelAndView mav = new ModelAndView();
        System.out.println(exerciseRepo.getAllExercises());
        mav.addObject("exercises", exerciseRepo.getAllExercises());
        mav.setViewName("AllExercises");
        return mav;
    }

    @RequestMapping(path="/trainer/exercises/filter", method=RequestMethod.GET)
    public ModelAndView filterExercises(@RequestParam (value="categoryFilter", defaultValue="All") String exerciseCat) {
        ModelAndView mav = new ModelAndView();
        if(exerciseCat.equals("All")){
            mav.addObject("exercises", exerciseRepo.getAllExercises());
            mav.setViewName("AllExercises");
            return mav;
        } else {
            System.out.println(exerciseRepo.filterExercises(exerciseCat));
            mav.addObject("exercises", exerciseRepo.filterExercises(exerciseCat));
            mav.setViewName("AllExercises");
            return mav;
        }

    }

    @RequestMapping(path="trainer/exercises/view", method= RequestMethod.GET)
    public ModelAndView getExercise(@RequestParam(value="exerciseID", defaultValue="") String exerciseID){
        int ID = Integer.parseInt(exerciseID);
        System.out.println(ID);
        ModelAndView mav = new ModelAndView();
        mav.addObject("exercise", exerciseRepo.viewExercise(ID));
        mav.setViewName("ViewExercise");
        return mav;
    }


    @RequestMapping(path="/trainer/exercises/add", method= RequestMethod.GET)
    public ModelAndView createExercise() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("CreateExercise");
        return mav;
    }

    @RequestMapping(path = "/trainer/exercises/add", method= RequestMethod.POST)
    public String trainerAddExercise (ExerciseForm exerciseForm, BindingResult br) {
        if (br.hasErrors()) {
            System.out.println(br.toString());
            return br.toString();
        } else {
            exerciseRepo.addExercise((exerciseForm));
            return "redirect:all" ;
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




}


