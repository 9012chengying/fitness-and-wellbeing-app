package uk.ac.cf.nsa.web.phyt.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;
import uk.ac.cf.nsa.web.phyt.client.repository.ClientWorkoutRepository;

@Controller
@RequestMapping(path="/client/diary")
public class DiaryController {

    private ClientWorkoutRepository clientWorkoutRepository;
    private UserService userService;

    @Autowired
    public DiaryController(ClientWorkoutRepository clientWorkoutRepository, UserService userService) {
        this.clientWorkoutRepository = clientWorkoutRepository;
        this.userService = userService;
    }

    @GetMapping(path="")
    public ModelAndView viewDiary() {
        ModelAndView mav = new ModelAndView();
        UserEntity currentUser = userService.authenticateUser();
        int userID = currentUser.getUserId();
        mav.addObject("workouts", clientWorkoutRepository.clientWorkoutDiary(userID));
        mav.setViewName("ClientDiary");
        return mav;
    }

    @GetMapping(path="/workout")
    public ModelAndView newWorkout(@RequestParam(value="workoutID", defaultValue="null") int workoutID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("workout", clientWorkoutRepository.workoutOverview(workoutID));
        mav.addObject("exercises", clientWorkoutRepository.workoutExerciseDetails(workoutID));
        mav.addObject("categories", clientWorkoutRepository.workoutCategories(workoutID));
        mav.setViewName("ClientWorkoutPreview");
        return mav;
    }
}
