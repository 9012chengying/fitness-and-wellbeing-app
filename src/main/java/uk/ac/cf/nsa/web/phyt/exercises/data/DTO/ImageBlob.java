package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;


public class ImageBlob {
    private int id;
    private int exercise_id;
    private String name;
    private String type;
    private byte[] imageData;

    public ImageBlob() {
    }

    //Constructor for Image object that doesn't exist in db yet
    public ImageBlob(int exercise_id, String name, String type, byte[] data) {
        this.exercise_id = exercise_id;
        this.name = name;
        this.type = type;
        this.imageData = data;
    }

    //Constructor for image that exists in the database
    public ImageBlob(int id, int exercise_id, String name, String type, byte[] data) {
        this.id = id;
        this.exercise_id = exercise_id;
        this.name = name;
        this.type = type;
        this.imageData = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
