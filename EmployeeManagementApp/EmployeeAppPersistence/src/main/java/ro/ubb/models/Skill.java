package ro.ubb.models;

import ro.ubb.constants.TechnologyArea;

public class Skill {
    private int id;
    private String skillName;
    private TechnologyArea technologyArea;

    public Skill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public TechnologyArea getTechnologyArea() {
        return technologyArea;
    }

    public void setTechnologyArea(TechnologyArea technologyArea) {
        this.technologyArea = technologyArea;
    }
}