package uk.ac.cf.nsa.web.phyt.users.controllers;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.users.service.PhytUserDetailsService;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;


@Controller
public class UserController {

    @Autowired
    private PhytUserDetailsService phytUserDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(path="/register")
    public String trainerRegister() {
        return "register";
    }

    //Route for registering a Trainer to the app
    @RequestMapping(path = "/register/user", method = RequestMethod.POST)
    public String trainerAdd(UserForm userForm) {
        UserDTO user = userService.getUserInfo(userForm);
        if (user != null) {
            return "failRegister";
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
        String name = "NOT Logged On";
        String role = null;

        //get authentication information & store role information in role String & username in name string
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                role = authority.getAuthority();
            }
            String currentUserName = authentication.getName();
            name = currentUserName;
            System.out.println(name);
        }

        //display different page depending on role
        if (role.equals("ROLE_TRAINER")){
           // mav.addObject("info", userService.loadUserByUsername(name));
            mav.addObject("username", name);
            mav.setViewName("PtHomePage");
        } else {
            mav.setViewName("User");
        }
        return mav;
    }

    //    @RequestMapping(path = "/update/user")
//    public String trainerUpdate(UserForm userForm) {
//        registerRepository.updateUser(userForm);
//        return "redirect:/register/info/"+userForm.getUsername();
//    }

//    @RequestMapping(path="/register/info/{username}")
//    public ModelAndView trainerInfo(@PathVariable("username") String username) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("info", registerRepository.getUserInfo(username));
//        mav.setViewName("PtHomePage");
//        return mav;
//    }
//
//    @RequestMapping(path="/update/info")
//    public ModelAndView trainerUpdateInfo(String username) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("info", registerRepository.getUserInfo(username));
//        mav.setViewName("update");
//        return mav;
//    }
//
//    @RequestMapping(path = "/user/delete")
//    public String deleteUser(String username) {
//        boolean success= registerRepository.deleteUser(username);
//            return "redirect:/register";
//    }
}
