package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.Media;

//Image class
public class Image {

    private int id;
    private int exercise_id;
    private String name;
    private String type;
    private byte[] data;


    //Constructor for Image object that doesn't exist in db yet
    public Image(int exercise_id, String name, String type, byte[] data) {
        this.exercise_id = exercise_id;
        this.name = name;
        this.type = type;
        this.data = data;
    }

    //Constructor for image that exists in the database
    public Image(int id, int exercise_id, String name, String type, byte[] data) {
        this.id = id;
        this.exercise_id = exercise_id;
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
