package uk.ac.cf.nsa.web.phyt.workouts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.workouts.repository.WorkoutRepository;

@Controller
@RequestMapping(path="/client/diary")
public class DiaryController {

    private WorkoutRepository workoutRepository;

    @Autowired
    public DiaryController(WorkoutRepository pRepo) {
        workoutRepository = pRepo;
    }

    @GetMapping(path="")
    public ModelAndView viewDiary(/*@RequestParam (value="clientID", defaultValue="null") int intClientID*/) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("workouts", workoutRepository.clientWorkoutDiary(3));
        mav.setViewName("ClientDiary");
        return mav;
    }

    @GetMapping(path="/workout")
    public ModelAndView newWorkout(@RequestParam(value="workoutID", defaultValue="null") int workoutID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("workout", workoutRepository.newWorkout(workoutID));
        mav.addObject("exercises", workoutRepository.newWorkoutDetails(workoutID));
        mav.setViewName("ClientWorkoutPreview");
        return mav;
    }
}
