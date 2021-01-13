package uk.ac.cf.nsa.web.phyt.exercises.data.repository;


public interface UserRepository {

    //interface method to get trainer id from login information
    int getTrainerID(String username, String password);

    //Get user role from database
    String getUserRole(String username, String password);
}
