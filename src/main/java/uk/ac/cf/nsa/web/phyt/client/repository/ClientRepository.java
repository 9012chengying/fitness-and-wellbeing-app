package uk.ac.cf.nsa.web.phyt.client.repository;

import uk.ac.cf.nsa.web.phyt.client.DTO.ClientDTO;


public interface ClientRepository {

   ClientDTO getClientInfo(int id);

   boolean updateClientInfo(ClientDTO clientDTO);
}
