package uk.ac.cf.nsa.web.phyt.AllClients.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.Client;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.Repository.ViewClientsRepo;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AllClientsService {



    private final ViewClientsRepo viewClientsRepo;

    @Autowired
    public AllClientsService(ViewClientsRepo viewClientsRepo) {
        this.viewClientsRepo = viewClientsRepo;
    }

    public List<Client> listAllPtClients(int TrainerID){

        List<Client> allClients = viewClientsRepo.GetAllClients(TrainerID);

        for(int i = 0; i<allClients.size(); i++){
            Client client = allClients.get(i);
            Timestamp timestamp = client.getLastWorkout();
         client.setLastWorkoutAsString(client.dateFormater(timestamp));


        }

return allClients;
    }
}
