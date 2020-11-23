package ro.ubb.constants;

public enum Regions {
    Cluj(1,"Cluj"), Sibiu(2,"Sibiu");
    private int id;
    private String name;

    Regions(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
