package uk.ac.cf.nsa.web.phyt.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.client.repository.WorkoutRepository;

@Controller
@RequestMapping(path="/client/workout")
public class ClientWorkoutController {
    private WorkoutRepository workoutRepository;

    @Autowired
    public ClientWorkoutController(WorkoutRepository pRepo) {
        workoutRepository = pRepo;
    }

    @GetMapping(path="")
    public ModelAndView latestWorkout(/*@RequestParam(value="clientID", defaultValue="null") int clientID*/) { //client ID should come from login - this is just to get it to work for now
        ModelAndView mav = new ModelAndView();
        int workoutID = workoutRepository.findIncompleteWorkoutID(2); //client ID should come from login - this is just to get it to work for now
        if (workoutID == -1) {
            mav.setViewName("NoNewWorkouts"); //maybe change to restController or modal
        } else {
            mav.addObject("workout", workoutRepository.workoutOverview(workoutID));
            mav.addObject("exercises", workoutRepository.workoutExerciseDetails(workoutID));
            mav.addObject("categories", workoutRepository.workoutCategories(workoutID));
            mav.setViewName("ClientWorkoutPreview");
        }
        return mav;
    }

    @GetMapping(path="/exercise")
    public ModelAndView viewExercise(int exerciseID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exercise", workoutRepository.viewExerciseByID(exerciseID));
        mav.addObject("media", workoutRepository.mediaByExerciseID(exerciseID));
        mav.setViewName("ClientExerciseView");
        return mav;
    }

    @GetMapping(path="/timer")
    public ModelAndView startTimer(@RequestParam(value="workoutID", defaultValue="null") int workoutID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("workout", workoutRepository.workoutOverview(workoutID));
        mav.addObject("exercises", workoutRepository.exerciseNameByWorkoutID(workoutID));
        mav.addObject("thumbnails", workoutRepository.exerciseThumbnailByWorkoutID(workoutID));
        mav.setViewName("Timer");
        return mav;
    }
}
