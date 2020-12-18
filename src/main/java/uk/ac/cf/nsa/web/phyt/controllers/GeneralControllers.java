package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralControllers {

    @RequestMapping(path="/trainer/clients")
    public String trainerAllClients() {
        return "clients";
    }

    @RequestMapping(path="/trainer/exercises/add", method=RequestMethod.GET)
    public ModelAndView createExercise() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "");
        mav.setViewName("CreateExercise");
        return mav;
    }

}
