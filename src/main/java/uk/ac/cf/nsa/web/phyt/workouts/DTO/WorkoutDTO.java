package uk.ac.cf.nsa.web.phyt.workouts.DTO;

import java.sql.Date;

public class WorkoutDTO {
    private int id;
    private int clientID;
    private int exerciseLength;
    private int restLength;
    private int repRest;
    private int reps;
    private Date dueDate;
    private boolean completed;
    private Date completedDate;
    private Date createdDate;
    private String imageSrc;
    private String altText;
    private String type;
    //private List<Integer> exerciseID;

    public WorkoutDTO(int id, int clientID, int exerciseLength, int restLength, int repRest, int reps, Date dueDate, boolean completed, Date completedDate, Date createdDate, String imageSrc, String altText, String type) {
        this.id = id;
        this.clientID = clientID;
        this.exerciseLength = exerciseLength;
        this.restLength = restLength;
        this.repRest = repRest;
        this.reps = reps;
        this.dueDate = dueDate;
        this.completed = completed;
        this.completedDate = completedDate;
        this.createdDate = createdDate;
        this.imageSrc = imageSrc;
        this.altText = altText;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getClientID() {
        return clientID;
    }

    public int getExerciseLength() {
        return exerciseLength;
    }

    public int getRestLength() {
        return restLength;
    }

    public int getRepRest() {
        return repRest;
    }

    public int getReps() {
        return reps;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getAltText() {
        return altText;
    }

    public String getType() {
        return type;
    }

    /*public int exerciseCount() {
        return exerciseID.size();
    }
     */

    public String workoutLength() {
        int totalRepLength = 4  * (exerciseLength + restLength); //4 needs to be replaced by exercise count
        int totalWorkoutLengthInSeconds = reps * (totalRepLength + repRest);
        int hh = totalWorkoutLengthInSeconds / 3600;
        int remainder = totalWorkoutLengthInSeconds % 3600;
        int mm = remainder / 60;
        int ss = remainder % 60;
        if (hh == 0) {
            if (ss < 10) {
                return mm + ":0" + ss;
            } else {
                return mm + ":" + ss;
            }
        } else {
            return hh + ":" + mm + ":" + ss;
        }
    }
}
