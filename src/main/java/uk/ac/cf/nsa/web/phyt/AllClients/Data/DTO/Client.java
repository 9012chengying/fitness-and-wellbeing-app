package uk.ac.cf.nsa.web.phyt.AllClients.Data.DTO;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Client {


    private int client_id;
    private int Trainer_id = 2;
    private String firstName;
    private String lastName;
    private String lastWorkoutAsString;
    private int numOfWorkouts;
    private Timestamp lastWorkout;

    public Client(){};

    public Client(String firstName, String lastName, Timestamp lastWorkout, int client_id, int numOfWorkouts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastWorkout = lastWorkout;
        this.client_id = client_id;
        this.numOfWorkouts = numOfWorkouts;
    }
    public int getClient_id() {
        return client_id;
    }

    public int getNumOfWorkouts() {
        return numOfWorkouts;
    }

    public void setNumOfWorkouts(int numOfWorkouts) {
        this.numOfWorkouts = numOfWorkouts;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
    public String getLastWorkoutAsString() {
        return lastWorkoutAsString;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Timestamp getLastWorkout() {
        return lastWorkout;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastWorkout(Timestamp lastWorkout) {
        this.lastWorkout = lastWorkout;
    }

    public int getTrainer_id() {
        return Trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.Trainer_id = trainer_id;
    }

    public void setLastWorkoutAsString(String lastWorkoutAsString) {
        this.lastWorkoutAsString = lastWorkoutAsString;
    }


public String dateFormater(Timestamp sqlDate){

//        Date date = new Date();
    Timestamp timestamp = new Timestamp(sqlDate.getTime());
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");


    return formatDate.format(timestamp);



}



}


