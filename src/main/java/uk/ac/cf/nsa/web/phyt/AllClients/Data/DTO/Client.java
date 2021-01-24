package uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO;

public class Client {
    private int Trainer_id = 2;
    private String firstName;
    private String lastName;
    private String lastWorkout;

    public Client(String firstName, String lastName, String lastWorkout) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastWorkout = lastWorkout;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastWorkout() {
        return lastWorkout;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastWorkout(String lastWorkout) {
        this.lastWorkout = lastWorkout;
    }

    public int getTrainer_id() {
        return Trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.Trainer_id = trainer_id;
    }

//    @Override
//    public String toString(){
//
//
//    }
}


