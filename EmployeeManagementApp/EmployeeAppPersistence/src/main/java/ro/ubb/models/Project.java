package ro.ubb.models;

public class Project {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                '}';
    }

    private int id_customer;
    private int duration;
    private String description;
    private int id_industry;

    public Project(){

    }
    public Project(int id,String name,int id_customer,int duration, String description,int id_industry){
        this.id=id;
        this.name=name;
        this.id_customer=id_customer;
        this.duration=duration;
        this.description=description;
        this.id_industry=id_industry;

    }

    public Project(String name,int duration, String description){
        this.name=name;
        this.duration=duration;
        this.description=description;

    }

    public Project(int id,String name,int duration, String description,int id_industry){
        this.id=id;
        this.name=name;
        this.duration=duration;
        this.description=description;
        this.id_industry=id_industry;

    }
    public Project(String name,int duration, String description,int id_industry){
        this.name=name;
        this.duration=duration;
        this.description=description;
        this.id_industry=id_industry;

    }
    public Project(String name,int id_customer,int duration, String description,int id_industry){
        this.name=name;
        this.id_customer=id_customer;
        this.duration=duration;
        this.description=description;
        this.id_industry=id_industry;

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

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_industry() {
        return id_industry;
    }

    public void setId_industry(int id_industry) {
        this.id_industry = id_industry;
    }
}
