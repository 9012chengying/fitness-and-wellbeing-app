package uk.ac.cf.nsa.web.phyt.workouts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView latestWorkout(/*@RequestParam(value="clientID", defaultValue="null") int clientID*/) {
        ModelAndView mav = new ModelAndView();
        if (workoutRepository.incompleteWorkout(3) == null) {
            mav.setViewName("NoNewWorkouts");
        } else {
            //int workoutID = (int) workoutRepository.incompleteWorkout(3);
            mav.addObject("exercises", workoutRepository.incompleteWorkout(3));
            //mav.addObject("workouts", workoutRepository.workoutDetailsByWorkoutID(workoutID));
            mav.setViewName("ClientWorkoutPreview");
        }
        return mav;
    }

    @GetMapping(path="/timer")
    public ModelAndView startTimer() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Timer");
        return mav;
    }
}
