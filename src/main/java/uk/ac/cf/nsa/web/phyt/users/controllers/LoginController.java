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


    //
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



}
