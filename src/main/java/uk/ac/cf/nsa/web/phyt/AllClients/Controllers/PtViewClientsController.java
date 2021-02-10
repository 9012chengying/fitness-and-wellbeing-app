package uk.ac.cf.nsa.web.phyt.AllClients.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.Repository.ViewClientsRepo;
import uk.ac.cf.nsa.web.phyt.AllClients.Service.AllClientsService;

@Controller
@RequestMapping(path="/trainer")
public class PtViewClientsController {
    private final ViewClientsRepo viewClientsRepo;
    private final AllClientsService allClientsService;
    @Autowired
    public PtViewClientsController(ViewClientsRepo viewClientsRepo, AllClientsService allClientsService) {
        this.viewClientsRepo = viewClientsRepo;
        this.allClientsService = allClientsService;
    }

    @GetMapping(path = "/view-clients")
    public ModelAndView allClients(){
        ModelAndView mav = new ModelAndView();
//        mav.addObject("allClients",viewClientsRepo.GetAllClients(1));
        mav.addObject("allClients", allClientsService.listAllPtClients(1));

        mav.setViewName("clients");
        return mav;

    }
    @GetMapping(path = "/client-details/{id}")
    public ModelAndView viewClientDetails(@PathVariable int id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("allWorkouts",allClientsService.listAllClientWorkouts(id));
        mav.setViewName("clientViewDetails");
        return mav;


    }


}
