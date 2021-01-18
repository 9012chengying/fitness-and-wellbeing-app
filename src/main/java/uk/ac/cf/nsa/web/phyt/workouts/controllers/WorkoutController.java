package uk.ac.cf.nsa.web.phyt.workouts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.workouts.repository.WorkoutRepository;

@Controller
public class WorkoutController {

    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutController(WorkoutRepository pRepo) {
        workoutRepository = pRepo;
    }

    @RequestMapping(path="/viewDiary", method= RequestMethod.GET)
    public ModelAndView viewDiary(@RequestParam (value="clientID", defaultValue="null") int intClientID) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("workouts", workoutRepository.clientWorkoutDiary(intClientID));
        mav.setViewName("ClientDiary");
        return mav;
    }
}
