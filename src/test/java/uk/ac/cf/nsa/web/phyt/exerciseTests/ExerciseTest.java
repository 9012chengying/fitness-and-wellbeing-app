package uk.ac.cf.nsa.web.phyt.exerciseTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import uk.ac.cf.nsa.web.phyt.exercises.data.DTO.Exercise;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExerciseTest {

    private static Exercise exercise;

    @BeforeAll
    public static void before() {
        exercise = new Exercise();
    }

    @Test
    public void dateConverterTest(){
        //Set createdDate on new Exercise
        exercise.setCreatedDate(Timestamp.valueOf("2020-12-29 17:12:34"));
        Timestamp testDate = exercise.getCreatedDate();

        //Test method by setting DateStr using date converter method
        exercise.setDateStr(exercise.dateConverter(testDate));

        //Verify method has worked;
        assertEquals("29 Dec 2020", exercise.getDateStr());

    }

}
