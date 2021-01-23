package uk.ac.cf.nsa.web.phyt.exercises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.ImageBlob;
import uk.ac.cf.nsa.web.phyt.exercises.data.repository.ExerciseRepository;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ImageForm;

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

    public ImageBlob addFilesToDatabase(ImageForm imageForm){

        ImageBlob imageBlob = new ImageBlob();

            imageBlob.setExercise_id(imageForm.getExerciseID());
            MultipartFile multipartFile = imageForm.getMultipartFile();
            String imageName = multipartFile.getName();
            System.out.println(imageName);
            imageBlob.setName(imageName);
            try{
                byte[] imageBytes = multipartFile.getBytes();
                imageBlob.setImageData(imageBytes);
                System.out.println(imageBytes);
            } catch(IOException ioe){
                throw new RuntimeException("IOException in reading file",ioe);
            }
            String imageType = multipartFile.getContentType();
            System.out.println(imageType);
            imageBlob.setType(imageType);
        return imageBlob;
    }

}
