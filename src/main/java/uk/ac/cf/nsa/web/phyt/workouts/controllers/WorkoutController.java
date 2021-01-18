package uk.ac.cf.nsa.web.phyt.workouts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.workouts.repository.WorkoutRepository;

@Controller
@RequestMapping(path="/client/workout")
public class WorkoutController {
    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutController(WorkoutRepository pRepo) {
        workoutRepository = pRepo;
    }

    @GetMapping(path="")
    public ModelAndView latestWorkout(/*@RequestParam(value="clientID", defaultValue="null") int clientID*/) { //client ID should come from login - this is just to get it to work for now
        ModelAndView mav = new ModelAndView();
        int workoutID = workoutRepository.findIncompleteWorkoutID(2); //client ID should come from login - this is just to get it to work for now
        if (workoutID == -1) { //this doesn't work - need to figure out how to deal with null SQL query
            mav.setViewName("NoNewWorkouts");
        } else {
            mav.addObject("workout", workoutRepository.newWorkout(workoutID));
            mav.addObject("exercises", workoutRepository.newWorkoutDetails(workoutID));
            mav.setViewName("ClientWorkoutPreview");
        }
        return mav;
    }

    @GetMapping(path="/exercise")
    public ModelAndView viewExercise(int exerciseID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exercise",workoutRepository.);
        mav.setViewName("ClientExerciseView");
        return mav;
    }


    @GetMapping(path="/timer")
    public ModelAndView startTimer() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Timer");
        return mav;
    }
}
