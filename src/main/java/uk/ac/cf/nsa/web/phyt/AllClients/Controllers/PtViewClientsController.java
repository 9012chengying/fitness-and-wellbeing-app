package uk.ac.cf.nsa.web.phyt.AllClients.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.Repository.ViewClientsRepo;

@Controller
@RequestMapping(path="/trainer")
public class PtViewClientsController {
    private final ViewClientsRepo viewClientsRepo;

    @Autowired
    public PtViewClientsController(ViewClientsRepo viewClientsRepo) {
        this.viewClientsRepo = viewClientsRepo;
    }

    @GetMapping(path = "/view-clients")
    public ModelAndView allClients(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allClients",viewClientsRepo.GetAllClients(2));
        mav.setViewName("clients");
        return mav;

    }


}
