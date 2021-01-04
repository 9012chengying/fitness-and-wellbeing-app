package uk.ac.cf.nsa.web.phyt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.service.ExerciseManagementService;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ExerciseManagementServiceTests {

    @Autowired
    private ExerciseManagementService exerciseManagementService;
    private JdbcTemplate jdbcTemplate;



    @Test
    public void createNewExerciseTest(){

         //Create an exercise
        ExerciseForm anExercise = new ExerciseForm();
        anExercise.setExerciseName("Alternate Leg Lunges");
        anExercise.setExerciseDesc("Description of lunges");
        anExercise.setExerciseCat("Lower body");

        //Test adding the new exercise
        boolean exerciseCreated = exerciseManagementService.createNewExercise(anExercise);

        //Verify the test
        assertTrue(exerciseCreated);
    }

    @Test
    public void viewExerciseTest(){
        
        // (exerciseManagementService.viewExercise("1") );

    }

    @Test
    public void addNewImageTest(){

    }
}
