package uk.ac.cf.nsa.web.phyt.exerciseTests;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.multipart.MultipartFile;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Image;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.ImageBlob;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ImageForm;
import uk.ac.cf.nsa.web.phyt.exercises.service.FileUploadService;

import java.io.File;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FileUploadServiceTests {

    private static ImageForm testImageForm;
    private static ImageBlob testImageBlob;

    @Autowired
    private FileUploadService fileUploadService;

    @BeforeAll
    public static void before() {
        testImageForm = new ImageForm();
        testImageBlob = new ImageBlob();
    }

    @Test
    public void addFilesToDatabaseTest(ImageForm imageForm, MultipartFile multipartFile){

    }
//    Java Code Examples for org.springframework.web.multipart ,
//    @PostMapping("/upload") public Object upload(@RequestParam("file")
//    MultipartFile file) throws IOException
//    { String originalFilename = file.
//    MultipartFile#getBytes.
//    MultipartFile has a getBytes () method that returns a byte array of the file's contents.
//    We can use this method to write the bytes to a file:
//    MultipartFile multipartFile = new MockMultipartFile ( "sourceFile.tmp", "Hello World" .getBytes ());
//

}
