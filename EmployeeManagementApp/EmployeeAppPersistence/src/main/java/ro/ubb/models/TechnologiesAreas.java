package ro.ubb.models;

public class TechnologiesAreas {
    private int idTech;
    private String techName;

    public TechnologiesAreas(int idTech, String techName) {
        this.idTech = idTech;
        this.techName = techName;
    }

    public int getIdTech() {
        return idTech;
    }

    public void setIdTech(int idTech) {
        this.idTech = idTech;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }
}
