package uk.ac.cf.nsa.web.phyt.UserInfo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.GeneralinfoPT;
import uk.ac.cf.nsa.web.phyt.UserInfo.Forms.PersonalTrainer;
import uk.ac.cf.nsa.web.phyt.UserInfo.Repository.ptRepo;

@Controller
@RequestMapping(path ="/trainer")
public class PtController {

    private final ptRepo personaltRepo;

    @Autowired
    public PtController(ptRepo personaltRepo) {
        this.personaltRepo = personaltRepo;
    }

//    @GetMapping(path="/")
//    public String getPT(){
//        return "PtHomePage";
//    }

    @GetMapping(path = "/YourAccount")
    public String getyourDetails(Model model){

        model.addAttribute("PersonalTrainer",new PersonalTrainer());
        model.addAttribute("Generalinfo", new GeneralinfoPT());
        return "YourAccountPage";
    }

    @GetMapping("/PtPersonalInfo")
    public String submitDetails(PersonalTrainer personalTrainer, GeneralinfoPT generalinfoPT,Model model){
        model.addAttribute("PersonalTrainer",personalTrainer);
        model.addAttribute("Generalinfo", generalinfoPT);

        personaltRepo.updatePtInfo(personalTrainer);

return "YourAccountPage";
    }
    @GetMapping("/PtGeneralInfo")
    public String submitDetails2(GeneralinfoPT generalinfoPT, PersonalTrainer personalTrainer, Model model){
        model.addAttribute("Generalinfo", generalinfoPT);
        model.addAttribute("PersonalTrainer",personalTrainer);

        personaltRepo.updatePtGeneral(generalinfoPT);
        return "YourAccountPage";

    }

    //TODO Add mapping so trainer can change profile image



}
