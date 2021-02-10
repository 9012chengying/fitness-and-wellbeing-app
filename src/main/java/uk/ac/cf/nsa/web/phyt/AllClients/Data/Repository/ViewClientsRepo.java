package uk.ac.cf.nsa.web.phyt.AllClients.Data.Repository;

import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.Client;
import uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO.ClientWorkout;

import java.util.List;

public interface ViewClientsRepo {

List<Client> GetAllClients(int trainerID);
List<ClientWorkout> GetAllWorkouts(int clientID);

}
