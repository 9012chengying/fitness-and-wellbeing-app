package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.ac.cf.nsa.web.phyt.forms.UserForm;
import uk.ac.cf.nsa.web.phyt.repository.LoginRepository;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    /**
     * init
     */
    @RequestMapping(path = "/")
    public String initLogin() {
        return "redirect:LoginPage";
    }

    /**
     * login
     */
    @RequestMapping(path = "/LoginPage")
    public String login(UserForm user, Model model, HttpSession session) {
        System.out.println(user.getUsername());
        if ("zhangsan".equals(user.getUsername())
                && "123456".equals(user.getPassword())) {
            // login success, sava info into session
            session.setAttribute("user", user);
            // redirect
            return "redirect:main";
        }
        model.addAttribute("msg", "Error, please enter again! ");
        return "login";
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
        return "login";
    }
}
