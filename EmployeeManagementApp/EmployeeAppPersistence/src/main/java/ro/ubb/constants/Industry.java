package ro.ubb.constants;

public enum Industry {
    Industry1(1,"Industry1"),Industry2(2,"Industry2");
    private int id;
    private String name;
    Industry(int id,String name){
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
