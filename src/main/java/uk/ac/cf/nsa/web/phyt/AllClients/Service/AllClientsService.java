//package uk.ac.cf.nsa.web.phyt.AllClients.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.Client;
//import uk.ac.cf.nsa.web.phyt.AllClients.Data.Repository.ViewClientsRepo;
//
//import java.util.List;
//
//@Service
//public class AllClientsService {
//
//    Client client;
//
//    private final ViewClientsRepo viewClientsRepo;
//    @Autowired
//    public AllClientsService(ViewClientsRepo viewClientsRepo) {
//        this.viewClientsRepo = viewClientsRepo;
//    }
//
//    public List<Client> listAllPtClients(){
//        List<Client> allClients = viewClientsRepo.GetAllClients(client.getTrainer_id());
//
//        for(int i = 0; i<allClients.size(); i++){
//            Client clients = allClients.get(i);
//
//        }
//
//return allClients;
//    }
//}
