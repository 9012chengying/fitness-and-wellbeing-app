package uk.ac.cf.nsa.web.phyt.workouts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.workouts.repository.WorkoutRepository;

@Controller
@RequestMapping(path="/client")
public class ClientController {

    private WorkoutRepository workoutRepository;

    @Autowired
    public ClientController(WorkoutRepository pRepo) {
        workoutRepository = pRepo;
    }

    @GetMapping(path="")
    public ModelAndView clientHome() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ClientHomePage");
        return mav;
    }
}