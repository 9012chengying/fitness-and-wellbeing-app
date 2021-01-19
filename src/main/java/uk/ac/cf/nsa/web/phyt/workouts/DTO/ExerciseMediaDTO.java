package uk.ac.cf.nsa.web.phyt.workouts.DTO;

public class ExerciseMediaDTO {
    private int exerciseID;
    private String type;
    private String src;
    private String altText;

    public ExerciseMediaDTO(int exerciseID, String type, String src, String altText) {
        this.exerciseID = exerciseID;
        this.type = type;
        this.src = src;
        this.altText = altText;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public String getType() {
        return type;
    }

    public String getSrc() {
        return src;
    }

    public String getAltText() {
        return altText;
    }
}
