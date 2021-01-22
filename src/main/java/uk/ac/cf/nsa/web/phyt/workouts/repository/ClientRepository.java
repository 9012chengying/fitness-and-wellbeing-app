package uk.ac.cf.nsa.web.phyt.workouts.repository;

import uk.ac.cf.nsa.web.phyt.workouts.DTO.ClientDTO;


public interface ClientRepository {

   ClientDTO getClientInfo(String name);

   boolean updateClientInfo(ClientDTO clientDTO);
}
