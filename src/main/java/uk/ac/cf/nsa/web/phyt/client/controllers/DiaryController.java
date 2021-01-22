package uk.ac.cf.nsa.web.phyt.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;
import uk.ac.cf.nsa.web.phyt.client.repository.WorkoutRepository;

@Controller
@RequestMapping(path="/client/diary")
public class DiaryController {

    private WorkoutRepository workoutRepository;
    private UserService userService;

    @Autowired
    public DiaryController(WorkoutRepository workoutRepository, UserService userService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
    }

    @GetMapping(path="")
    public ModelAndView viewDiary() {
        ModelAndView mav = new ModelAndView();
        UserEntity currentUser = userService.authenticateUser();
        int userID = currentUser.getUserId();
        mav.addObject("workouts", workoutRepository.clientWorkoutDiary(userID));
        mav.setViewName("ClientDiary");
        return mav;
    }

    @GetMapping(path="/workout")
    public ModelAndView newWorkout(@RequestParam(value="workoutID", defaultValue="null") int workoutID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("workout", workoutRepository.workoutOverview(workoutID));
        mav.addObject("exercises", workoutRepository.workoutExerciseDetails(workoutID));
        mav.addObject("categories", workoutRepository.workoutCategories(workoutID));
        mav.setViewName("ClientWorkoutPreview");
        return mav;
    }
}
