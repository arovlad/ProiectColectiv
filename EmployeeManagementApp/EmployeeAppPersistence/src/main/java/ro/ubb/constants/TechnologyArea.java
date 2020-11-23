package ro.ubb.constants;

public enum TechnologyArea {
    DATABASES("Databases"),
    FRAMEWORKS("Frameworks"),
    PROGRAMMING_LANGUAGE("Programming language");

    private final String technologyArea;

    TechnologyArea(String technologyArea) {
        this.technologyArea = technologyArea;
    }

    public String getTechnologyArea() {
        return technologyArea;
    }
}