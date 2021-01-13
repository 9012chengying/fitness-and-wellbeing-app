package uk.ac.cf.nsa.web.phyt.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.users.data.repository.LoginRepository;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //sets redirect to login page if user goes doesn't enter a specific route
    @RequestMapping(path = "/")
    public String initLogin() {
        return "redirect:login";
    }


    //Gets the login page and displays on browser
    @RequestMapping(path="/login", method = RequestMethod.GET)
    public String getLoginPage(Model model){
        return "login";
    }

    //Deals with the Post request when user enters log in details
    @RequestMapping(path="/login", method = RequestMethod.POST)
    public ModelAndView login(UserForm user) {
        ModelAndView mav = new ModelAndView();
        // get username user form
        String username= user.getUsername();
        //Send request to database to check credentials
        userService.loadUserByUsername(username);
        mav.addObject("name", username);
        mav.setViewName("TrainerHome");
        return mav;
    }


    /**
     * jump to main
     */
    @RequestMapping(path = "/main")
    public String toMain() {
        return "main";
    }

    /**
     * logout
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // clear session
        session.invalidate();
        return "redirect:LoginPage";
    }

//    @RequestMapping(path="/register/info/{username}")
//    public ModelAndView trainerInfo(@PathVariable("username") String username) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("info", loginRepository.getUserInfo(username));
//        mav.setViewName("PtHomePage");
//        return mav;
//    }
}
