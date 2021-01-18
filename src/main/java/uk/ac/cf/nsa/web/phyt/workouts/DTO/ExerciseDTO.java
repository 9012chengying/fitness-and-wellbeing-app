package uk.ac.cf.nsa.web.phyt.workouts.DTO;

public class ExerciseDTO {
    private int id;
    private String name;
    private String description;
    private String category;
    private String equipment;

    public ExerciseDTO(int id, String name, String description, String category, String equipment) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.equipment = equipment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getEquipment() {
        return equipment;
    }
}
