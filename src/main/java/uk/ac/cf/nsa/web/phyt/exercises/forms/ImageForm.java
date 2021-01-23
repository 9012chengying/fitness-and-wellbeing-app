package uk.ac.cf.nsa.web.phyt.exercises.forms;

import java.nio.file.Files;
import java.util.List;


public class ImageForm {

    int exerciseID;
    Files imageFiles;
    List<Byte> byteData;

    public ImageForm(int exerciseID, Files imageFiles) {
        this.exerciseID = exerciseID;
        this.imageFiles = imageFiles;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public Files getImageFiles() {
        return imageFiles;
    }

    public void setImageFiles(Files imageFiles) {
        this.imageFiles = imageFiles;
    }

    public Byte readFileData(Files imageFiles){

    }
}
