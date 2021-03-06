package uk.ac.cf.nsa.web.phyt.client.DTO;

public class WorkoutDTO {
    private int id;
    private int clientID;
    private int exerciseCount;
    private int exerciseLength;
    private int restLength;
    private int repRest;
    private int reps;
    private String equipment;
    private String dueDate;
    private boolean completed;
    private String completedDate;
    private String createdDate;
    private String thumbnailImg;

    public WorkoutDTO(int id, int clientID, int exerciseCount, int exerciseLength, int restLength, int repRest, int reps, String equipment, String dueDate, boolean completed, String completedDate, String createdDate, String thumbnailImg) {
        this.id = id;
        this.clientID = clientID;
        this.exerciseCount = exerciseCount;
        this.exerciseLength = exerciseLength;
        this.restLength = restLength;
        this.repRest = repRest;
        this.reps = reps;
        this.equipment = equipment;
        this.dueDate = dueDate;
        this.completed = completed;
        this.completedDate = completedDate;
        this.createdDate = createdDate;
        this.thumbnailImg = thumbnailImg;
    }

    public int getId() {
        return id;
    }

    public int getClientID() {
        return clientID;
    }

    public int getExerciseCount() {
        return exerciseCount;
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

    public String getEquipment() {
        return equipment;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public int workoutLength() {
        int totalRepLength = exerciseCount  * (exerciseLength + restLength);
        int totalWorkoutLengthInSeconds = reps * (totalRepLength + repRest);
        return totalWorkoutLengthInSeconds;
    }

    public String workoutLengthFormat() {
        int hh = workoutLength() / 3600;
        int remainder = workoutLength() % 3600;
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
