package uk.ac.cf.nsa.web.phyt.trainer.forms;

import java.sql.Date;

public class WorkoutDetailsForm {

    private int clientID;
    private int exerciseLength;
    private int exerciseRest;
    private int repRest;
    private int reps;
    private String equipment;
    private Date dueDate;
    /*private int dueDateMonth;
    private int dueDateYear;*/

    public WorkoutDetailsForm(int clientID, int exerciseLength, int exerciseRest, int repRest, int reps, String equipment, Date dueDate) {
        this.clientID = clientID;
        this.exerciseLength = exerciseLength;
        this.exerciseRest = exerciseRest;
        this.repRest = repRest;
        this.reps = reps;
        this.equipment = equipment;
        this.dueDate = dueDate;
    }

    public int getClientID() {
        return clientID;
    }

    public int getExerciseLength() {
        return exerciseLength;
    }

    public int getExerciseRest() {
        return exerciseRest;
    }

    public int getRepRest() {
        return repRest;
    }

    public int getReps() {
        return reps;
    }

    public String getEquipment() {
        return equipment;
    }

    public Date getDueDate() {
        return dueDate;
    }

    /*public int getDueDateDays() {
        return dueDateDays;
    }

    public int getDueDateMonth() {
        return dueDateMonth;
    }

    public int getDueDateYear() {
        return dueDateYear;
    }

    public String dueDate() {
        Format formatter = new SimpleDateFormat("MMM");
        String s = formatter.format(new Date());
        return dueDateDays + "-" + s + "-" + dueDateYear;
    }*/
}
