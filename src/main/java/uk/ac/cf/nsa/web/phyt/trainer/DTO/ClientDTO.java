package uk.ac.cf.nsa.web.phyt.trainer.DTO;

public class ClientDTO {

    private int trainerID;
    private int clientID;
    private String clientUsername;

    public ClientDTO(int trainerID, int clientID, String clientUsername) {
        this.trainerID = trainerID;
        this.clientID = clientID;
        this.clientUsername = clientUsername;
    }

    public int getTrainerID() {
        return trainerID;
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientUsername() {
        return clientUsername;
    }
}
