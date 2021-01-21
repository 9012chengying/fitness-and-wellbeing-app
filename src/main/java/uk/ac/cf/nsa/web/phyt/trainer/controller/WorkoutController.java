package uk.ac.cf.nsa.web.phyt.trainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.client.repository.WorkoutRepository;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.ExerciseRepository;

@Controller
@RequestMapping(path="trainer/workout/create")
public class WorkoutController {

    private ExerciseRepository exerciseRepo;

    @Autowired
    public WorkoutController(ExerciseRepository exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    @GetMapping(path="/exercises")
    public ModelAndView viewExercises() { //this will display all exercises but should be only the one's related to the trainer - should be fixed once login is merged
        ModelAndView mav = new ModelAndView();
        mav.addObject("exercises", exerciseRepo.getAllExercises());
        mav.setViewName("CreateWorkoutExercises");
        return mav;
    }

    /*@GetMapping(path="/details")
    public ModelAndView detailsForm() { //this will display all exercises but should be only the one's related to the trainer - should be fixed once login is merged
        ModelAndView mav = new ModelAndView();
        mav.addObject();
        mav.setViewName("WorkoutDetails"); //need to rename based on what Weibo calls
        return mav;
    }*/

}
