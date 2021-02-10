package uk.ac.cf.nsa.web.phyt.client.DTO;

public class ExerciseDTO {
    private int id;
    private String name;
    private String description;
    private String category;

    public ExerciseDTO(int id, String name, String description, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
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
}
