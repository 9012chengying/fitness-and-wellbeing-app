package uk.ac.cf.nsa.web.phyt.workouts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;
import uk.ac.cf.nsa.web.phyt.workouts.repository.WorkoutRepository;

@Controller
@RequestMapping(path="/client/workout")
public class WorkoutController {

    private WorkoutRepository workoutRepository;
    private UserService userService;

    @Autowired
    public WorkoutController(WorkoutRepository workoutRepository, UserService userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    @GetMapping(path="")
    public ModelAndView latestWorkout() {
        ModelAndView mav = new ModelAndView();
        UserEntity currentUser = userService.authenticateUser();
        int userID = currentUser.getUserId();
        int workoutID = workoutRepository.findIncompleteWorkoutID(userID);
        if (workoutID == -1) {
            mav.setViewName("NoNewWorkouts");
        } else {
            mav.addObject("workout", workoutRepository.workoutOverview(workoutID));
            mav.addObject("exercises", workoutRepository.workoutExerciseDetails(workoutID));
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
