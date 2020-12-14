package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralControllers {

<<<<<<<<< Temporary merge branch 1
    @RequestMapping(path="/trainer/clients")
    public String trainerAllClients() {
        return "clients";
    }

    @RequestMapping(path="/trainer/exercises")
    public String trainerExercises(){
        return "exercises";
    }
=========
@RequestMapping(path="/trainer/clients")
public String trainerAllClients(String name) {
    return "clients";
}
>>>>>>>>> Temporary merge branch 2


}
