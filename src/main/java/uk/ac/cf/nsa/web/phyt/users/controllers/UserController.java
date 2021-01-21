package uk.ac.cf.nsa.web.phyt.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserEntity;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @RequestMapping(path="/register", method=RequestMethod.GET)
    public String trainerRegister() {
        return "register";
    }

    //Route for registering a Trainer to the app
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String trainerAdd(UserForm userForm, Model model) {
        //Create user object by checking userForm username details against database
        UserDTO user = userService.getUserInfo(userForm);
        if (user != null) {
            model.addAttribute("registerMessage", "Username already taken");
            return "register";
        } else {
            userForm.setRole("Trainer");
            if (!userService.setUpNewTrainer(userForm)) {
                return "register";
            } else {
                return "redirect:/login";
            }
        }
    }

    //sets redirect to login page if user goes doesn't enter a specific route
    @RequestMapping(path = "/" , method=RequestMethod.GET)
    public String getHomepage() {
        return "redirect:/login";
    }


    //Gets the login page and displays on browser
    @RequestMapping(path="/login", method = RequestMethod.GET)
    public String getLoginPage(){
        return "login";
    }


    //User info route opens relevant page depending on user role details
    @RequestMapping(path="/home")
    public ModelAndView userAccountInfo() {
        ModelAndView mav = new ModelAndView();
        UserEntity currentUser = userService.authenticateUser();
        String name = currentUser.getFirstname();
        if(currentUser.getRole().equals("Trainer")){
            mav.addObject("name", name);
            mav.setViewName("Trainer");
            return mav;
        } else {
            mav.addObject("name", name);
            mav.setViewName("User");
            return mav;
        }
    }
}
