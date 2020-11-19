package ro.ubb.constants;

public enum ConsultingLevel {
    JuniorConsultant(1,"Junior Consultant"), Consultant(2,"Consultant"),
    SeniorConsultant(3,"Senior Consultant"), Manager(4,"Manager"),
    SeniorManager(5,"Senior Manager"),
    AssociatedPartner(6,"Associated Partner"), Partner(7, "Partner");
    private int id;
    private String name;

    ConsultingLevel(int id, String name) {
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