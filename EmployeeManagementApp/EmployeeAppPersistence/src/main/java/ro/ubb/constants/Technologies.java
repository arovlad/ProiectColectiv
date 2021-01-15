package ro.ubb.constants;

public enum Technologies {
    DATABASES("Databases"),
    FRAMEWORKS("Frameworks"),
    PROGRAMMING_LANGUAGE("Programming language");

    private final String Technologies;

    Technologies(String Technologies) {
        this.Technologies = Technologies;
    }

    public String getTechnologies() {
        return Technologies;
    }
}