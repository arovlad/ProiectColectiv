package ro.ubb.constants;

public enum Customer {
    CUSTOMER1(1,"Customer1"), CUSTOMER2(2,"Customer2"), CUSTOMER3(3,"Customer3");
    private int id;
    private String name;
    Customer(int id, String name){
        this.id=id;
        this.name=name;
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
