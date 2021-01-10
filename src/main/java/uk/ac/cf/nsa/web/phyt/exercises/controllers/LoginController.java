package uk.ac.cf.nsa.web.phyt.exercises.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.exercises.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.exercises.forms.LoginForm;
import uk.ac.cf.nsa.web.phyt.exercises.repository.UserRepository;

public class LoginController {

    @Autowired
    private UserRepository UserRepository;

    /**
     * Jump to the PT/client home pages
     */
    @RequestMapping(path="/login",method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(path = "/register/user")
    public String trainerAdd(UserForm userForm) {
        UserEntity user = registerRepository.getUserInfo(userForm.getUsername());
        if (user!=null){
            return "failRegister";
        }
        registerRepository.registerUser(userForm);
        return "redirect:info/"+userForm.getUsername();
    }

    @RequestMapping(path="/register/info/{username}")
    public ModelAndView trainerInfo(@PathVariable("username") String username) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("info", registerRepository.getUserInfo(username));
        mav.setViewName("PtHomePage");
        return mav;
    }
}
