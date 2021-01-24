package uk.ac.cf.nsa.web.phyt.exercises.forms;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.util.List;


public class ImageForm {

    int exerciseID;
    MultipartFile multipartFile;

    public ImageForm() {
    }

    public ImageForm(int exerciseID, MultipartFile multipartFile) {
        this.exerciseID = exerciseID;
        this.multipartFile = multipartFile;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
