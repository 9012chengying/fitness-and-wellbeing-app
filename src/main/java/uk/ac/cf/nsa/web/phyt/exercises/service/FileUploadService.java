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

    public ImageBlob createImageBlob(ImageForm imageForm, MultipartFile multipartFile){

        ImageBlob imageBlob = new ImageBlob();
        imageBlob.setExercise_id(imageForm.getExerciseID());
        String imageName = multipartFile.getOriginalFilename();
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

    public boolean addFilesToDatabase(ImageForm imageForm, MultipartFile multipartFile){
        ImageBlob imageBlob = createImageBlob(imageForm, multipartFile);
        exerciseRepo.addImage(imageBlob);
        if(!exerciseRepo.addImage(imageBlob)){
            return false;
        } else {
            return true;
        }
    }

}
