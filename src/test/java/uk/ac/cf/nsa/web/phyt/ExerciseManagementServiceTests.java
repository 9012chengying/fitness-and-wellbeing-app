package uk.ac.cf.nsa.web.phyt;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.service.ExerciseManagementService;
import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ExerciseManagementServiceTests {


    @Autowired
    private ExerciseManagementService exerciseManagementService;


    @Test
    public void createNewExerciseTest(){

        ExerciseForm testExerciseForm;

         //Create an exercise
        testExerciseForm = new ExerciseForm();
        testExerciseForm.setExerciseName("Alternate Leg Lunges");
        testExerciseForm.setExerciseDesc("Description of lunges");
        testExerciseForm.setExerciseCat("Lower body");
        System.out.println(testExerciseForm.toString());

        //Test adding the new exercise
        boolean exerciseCreated = exerciseManagementService.createNewExercise(testExerciseForm);


        //Verify the test
        assertTrue(exerciseCreated);
    }


    @Test
    public void viewExerciseTest(){

        Exercise testExercise;

        //assign output from viewExercise with exercise ID = 1 , to testExercise object
        testExercise = exerciseManagementService.viewExercise("1");

        //verify that testExercise name equals Plank
        assertEquals("Plank", testExercise.getExerciseName());
    }

    @Test
    public void listAllExercisesTest(){

    }

    @Test
    public void addNewImageTest(){

    }
}
