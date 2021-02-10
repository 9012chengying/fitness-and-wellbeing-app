package uk.ac.cf.nsa.web.phyt.exerciseTests;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import uk.ac.cf.nsa.web.phyt.exercises.forms.ExerciseForm;
import uk.ac.cf.nsa.web.phyt.exercises.service.ExerciseManagementService;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.UserDTO;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

//TESTS FOR THE EXERCISE MANAGEMENT SERVICE

public class ExerciseManagementServiceTests {

    private static ExerciseForm testExerciseForm;
    private static Exercise testExercise;

    @Autowired
    private ExerciseManagementService exerciseManagementService;


    @BeforeAll
    public static void before() {
        testExercise = new Exercise();
        testExerciseForm = new ExerciseForm(1, "Test Name", "Test Description", "Core", null);
    }

    @Test
    public void createNewExerciseTest() {


        //Create an exercise
        testExerciseForm.setExerciseName("Alternate Leg Lunges");
        testExerciseForm.setExerciseDesc("Description of lunges");
        testExerciseForm.setExerciseCat("Lower body");
        testExerciseForm.setExerciseVideo("https://www.youtube.com/embed/PWic8ckZ1q0");

        System.out.println(testExerciseForm.toString());

        //Test adding the new exercise - should return true when created
        boolean exerciseCreated = exerciseManagementService.createNewExercise(testExerciseForm);

        //Verify the test
        assertTrue(exerciseCreated);
    }



    @Test
    public void viewExerciseTest() {

        //assign output from viewExercise with exercise ID = 1 , to testExercise object
        testExercise = exerciseManagementService.viewExercise("1");

        //verify that testExercise has name of Plank and Category of Core
        assertEquals("Plank", testExercise.getExerciseName());
        assertEquals("Core", testExercise.getExerciseCat());
    }

    @Test
    public void listAllExercisesTest() {

        //create a new exercise test list
        List<Exercise> testList;

        //assign output from listAllExercises to new list
        testList = exerciseManagementService.listAllExercises(1);

        //verify that the list is not empty
        assertNotNull(testList);
    }

    @Test
    public void listExercisesByCategory() {

        //create a new exercise test list
        List<Exercise> testListByCat;

        //assign output from listExercisesByCategory to test list
        testListByCat = exerciseManagementService.listExercisesByCategory("Cardio", 1);

        //verify list not empty
        assertNotNull(testListByCat);

        //verify that category for each item in list is Cardio
        for (int i = 0; i < testListByCat.size(); i++) {
            assertEquals("Cardio", testListByCat.get(i).getExerciseCat());
        }

    }

    /* EDIT EXERCISE TEST */
    @Test
    public void editExercise (){

        //Get existing exercise information use existing viewExercise method
        testExercise = exerciseManagementService.viewExercise("5");

        //Use testExercise to populate ExerciseForm
        testExerciseForm.setExerciseID(testExercise.getExerciseID());
        testExerciseForm.setExerciseName(testExercise.getExerciseName());
        testExerciseForm.setExerciseDesc(testExercise.getExerciseDesc());
        testExerciseForm.setExerciseCat(testExercise.getExerciseCat());

        //verify testExercise is equal to testExerciseForm before changes - should pass
        assertEquals(testExercise.getExerciseID(), testExerciseForm.getExerciseID());
        assertEquals(testExercise.getExerciseName(), testExerciseForm.getExerciseName());
        assertEquals(testExercise.getExerciseDesc(), testExerciseForm.getExerciseDesc());
        assertEquals(testExercise.getExerciseCat(), testExerciseForm.getExerciseCat());

        //Change some information on the testExerciseForm
        testExerciseForm.setExerciseDesc("Testing that description is changed");
        testExerciseForm.setExerciseCat("Core");

        //Verify that testExercise no longer matches testExerciseForm except for ID & Name
        assertEquals(testExercise.getExerciseID(), testExerciseForm.getExerciseID());
        assertEquals(testExercise.getExerciseName(), testExerciseForm.getExerciseName());
        assertNotEquals(testExercise.getExerciseDesc(), testExerciseForm.getExerciseDesc());
        assertNotEquals(testExercise.getExerciseCat(), testExerciseForm.getExerciseCat());

        //Update Exercise using edit method
        exerciseManagementService.editExercise(testExerciseForm);

        //call the viewExercise method again and assign to testExercise
        testExercise = exerciseManagementService.viewExercise("5");

        //Verify that testExercise now matches exerciseForm
        assertEquals(testExercise.getExerciseID(), testExerciseForm.getExerciseID());
        assertEquals(testExercise.getExerciseName(), testExerciseForm.getExerciseName());
        assertEquals(testExercise.getExerciseDesc(), testExerciseForm.getExerciseDesc());
        assertEquals(testExercise.getExerciseCat(), testExerciseForm.getExerciseCat());
    }


    /*
    DELETE EXERCISE TESTS
     */

    @Test //Test that a success message is returned if an exercise is not deleted
    public void deleteExerciseTestHappyPath() {

        String exerciseID = "21"; //**Check database for an existing record and change ID if required**

        //delete exercise using Exercise ID & return a string message
        String exerciseDeleted = exerciseManagementService.deleteExercise(exerciseID);

        //verify exercise deleted
        assertEquals("success", exerciseDeleted);
    }

    @Test //Test that a failed message is returned if exercise is not deleted
    public void deleteExerciseTestExceptionPath() {

        String exerciseID = "30";

        //Try to delete exercise using Exercise ID & return a string message
        String exerciseDeleted = exerciseManagementService.deleteExercise(exerciseID);

        //verify exercise not deleted
        assertEquals("failed", exerciseDeleted);
    }

}



