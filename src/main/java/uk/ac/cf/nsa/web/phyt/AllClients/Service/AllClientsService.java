package uk.ac.cf.nsa.web.phyt.AllClients.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.Client;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.ClientWorkout;
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
    public List<ClientWorkout> listAllClientWorkouts(int ClientID){
        List<ClientWorkout> allWorkouts = viewClientsRepo.GetAllWorkouts(ClientID);
        for(int i =0; i<allWorkouts.size(); i++){
            ClientWorkout clientWorkout = allWorkouts.get(i);
            Timestamp timestamp1 = clientWorkout.getComplete_by();
            Timestamp timestamp2 = clientWorkout.getCreated_at();
            clientWorkout.setStringComplete_by(clientWorkout.dateFormater(timestamp1));
            clientWorkout.setStringCreated_at(clientWorkout.dateFormater(timestamp2));
            if(clientWorkout.getCompleted_at()==null){

                clientWorkout.setCompleted_at(null);
                clientWorkout.setStringCompleted_at("null");
            }
            else {
                Timestamp timestamp3 = clientWorkout.getCompleted_at();
                clientWorkout.setStringCompleted_at(clientWorkout.dateFormater(timestamp3));
            }
            if(!clientWorkout.isIs_completed()){
                clientWorkout.setCompleted("This workout has not been completed.");
                }
            else {
                clientWorkout.setCompleted("This workout has been completed.");
            }

            }
        return  allWorkouts;
        }

    }

