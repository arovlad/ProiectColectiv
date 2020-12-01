package ro.ubb.constants;

public enum ProjectRole {
    ProjectManager(1, "Project Manager"), Analyst(2, "Analyst"), SoftwareArchitect(3, "Software Architect"),
    Tester(4, "Tester"), DatabaseAdministrator(5, "Database Administrator");

    private int id;
    private String name;

    ProjectRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
