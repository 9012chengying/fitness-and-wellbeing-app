package uk.ac.cf.nsa.web.phyt.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;
import uk.ac.cf.nsa.web.phyt.client.repository.ClientWorkoutRepository;

@Controller
@RequestMapping(path="/client/workout")
public class ClientWorkoutController {

    private ClientWorkoutRepository clientWorkoutRepository;
    private UserService userService;

    @Autowired
    public ClientWorkoutController(ClientWorkoutRepository clientWorkoutRepository, UserService userService) {
        this.clientWorkoutRepository = clientWorkoutRepository;
        this.userService = userService;
    }

    @GetMapping(path="")
    public ModelAndView latestWorkout() {
        ModelAndView mav = new ModelAndView();
        UserEntity currentUser = userService.authenticateUser();
        int userID = currentUser.getUserId();
        int workoutID = clientWorkoutRepository.findIncompleteWorkoutID(userID);
        if (workoutID == -1) {
            mav.setViewName("NoNewWorkouts");
        } else {
            mav.addObject("workout", clientWorkoutRepository.workoutOverview(workoutID));
            mav.addObject("exercises", clientWorkoutRepository.workoutExerciseDetails(workoutID));
            mav.setViewName("ClientWorkoutPreview");
        }
        return mav;
    }

    @GetMapping(path="/exercise")
    public ModelAndView viewExercise(int exerciseID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exercise", clientWorkoutRepository.viewExerciseByID(exerciseID));
        mav.addObject("media", clientWorkoutRepository.mediaByExerciseID(exerciseID));
        mav.setViewName("ClientExerciseView");
        return mav;
    }

    @GetMapping(path="/timer")
    public ModelAndView startTimer(@RequestParam(value="workoutID", defaultValue="null") int workoutID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("workout", clientWorkoutRepository.workoutOverview(workoutID));
        mav.addObject("exercises", clientWorkoutRepository.exerciseNameByWorkoutID(workoutID));
        mav.addObject("thumbnails", clientWorkoutRepository.exerciseThumbnailByWorkoutID(workoutID));
        mav.setViewName("Timer");
        return mav;
    }

    @RequestMapping(path="/workoutComplete", method=RequestMethod.POST) //should this be a rest controller returning a string?
    public ModelAndView workoutComplete(@RequestParam(value="workoutID", defaultValue="null") int workoutID) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Client");
        return mav;
    }
}
