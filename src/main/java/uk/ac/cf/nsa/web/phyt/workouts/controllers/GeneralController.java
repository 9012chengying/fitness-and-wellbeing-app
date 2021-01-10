package uk.ac.cf.nsa.web.phyt.workouts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {

    @RequestMapping(path="/Client")
    public ModelAndView clientProfile() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ClientID");
        return mav;
    }
}
