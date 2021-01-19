package uk.ac.cf.nsa.web.phyt.users.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {


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
    @RequestMapping(path="/userInfo")
    public ModelAndView userAccountInfo() {
        ModelAndView mav = new ModelAndView();
        System.out.println("GeneralController --- /userAccountInfo    getting info ");
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
        }
        mav.addObject("role", role);
        mav.addObject("name", name);

        //display different page depending on role
        if (role.equals("ROLE_TRAINER")){
            mav.setViewName("Trainer");
        } else {
            mav.setViewName("User");
        }
        return mav;
    }
}
