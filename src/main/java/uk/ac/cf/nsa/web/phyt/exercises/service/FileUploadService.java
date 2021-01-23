package uk.ac.cf.nsa.web.phyt.exercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.ImageBlob;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.ExerciseRepository;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadService {

    private final ExerciseRepository exerciseRepo;

    @Autowired
    public FileUploadService(ExerciseRepository exerciseR) {
        this.exerciseRepo = exerciseR;
    }

    public ArrayList<ImageBlob> addFilesToDatabase(MultipartFile[] multipartFiles, int exerciseID){
        //initiate an arraylist to store image objects
         ArrayList<ImageBlob> images = new ArrayList<ImageBlob>();
        for (MultipartFile multipartFile: multipartFiles) {
            ImageBlob newImageBlob = new ImageBlob();
            newImageBlob.setExercise_id(exerciseID);
            String imageName = multipartFile.getName();
            System.out.println(imageName);
            newImageBlob.setName(imageName);
            try{
                byte[] imageBytes = multipartFile.getBytes();
                newImageBlob.setImageData(imageBytes);
                System.out.println(imageBytes);
            } catch(IOException ioe){
                throw new RuntimeException("IOException in reading file",ioe);
            }
            String imageType = multipartFile.getContentType();
            System.out.println(imageType);
            newImageBlob.setType(imageType);
            images.add(newImageBlob);
          }
        return images;
    }

}
