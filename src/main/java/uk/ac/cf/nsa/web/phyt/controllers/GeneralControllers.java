package uk.ac.cf.nsa.web.phyt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralControllers {

<<<<<<< HEAD
    @RequestMapping(path="/trainer/clients")
    public String trainerAllClients() {
        return "clients";
    }

    @RequestMapping(path="/trainer/exercises")
    public String trainerExercises(){
        return "exercises";
    }
=======
@RequestMapping(path="/trainer/clients")
public String trainerAllClients(String name) {
    return "clients";
}
>>>>>>> 8f7c5788d9b9b703eddeaf20174e39a4b5f38770


}
