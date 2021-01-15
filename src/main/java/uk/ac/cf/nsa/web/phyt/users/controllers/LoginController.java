package uk.ac.cf.nsa.web.phyt.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;
import uk.ac.cf.nsa.web.phyt.users.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.users.data.repository.LoginRepository;
//import uk.ac.cf.nsa.web.phyt.users.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    //private UserService userService;

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

    @RequestMapping(path="/userInfo")
    public ModelAndView userAccountInfo(Authentication authentication) {
        ModelAndView mav = new ModelAndView();
        System.out.println("GeneralController --- /userAccountInfo    getting info ");
        String name = "NOT Logged On";
        String role = null;
       authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                role = authority.getAuthority();
            }
            String currentUserName = authentication.getName();
            name = currentUserName;
        }
        mav.addObject("role", role);
        mav.addObject("name", name);
        mav.setViewName("User");
        return mav;
    }
//    //Deals with the Post request when user enters log in details
//    @RequestMapping(path="/loginuser", method = RequestMethod.POST)
//    public String login(UserForm user) {
//        // get username user form
//        String username= user.getUsername();
//        //Send request to database to check credentials
//        //userService.loadUserByUsername(username);
//        return "user-logged-in";
//    }


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
