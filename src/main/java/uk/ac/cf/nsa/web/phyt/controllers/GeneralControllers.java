package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralControllers {

@RequestMapping(path="/trainer/clients")
public String trainerAllClients(String name) {
    return "clients";
}


}
