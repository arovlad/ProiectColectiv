package ro.ubb.constants;

public enum UserRole {
    Employee(1,"Employee"), Administrator(2,"Administrator"), Supervisor(3,"Supervisor");
    private int id;
    private String name;

    UserRole(int id, String name) {
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
