package ro.ubb.models;

public class ProfileSkills {
    private int id;
    private int id_profile;
    private int id_skill;
    private int skill_knowledge_level;

    public ProfileSkills() {

    }

    public ProfileSkills(int id, int id_profile, int id_skill, int skill_knowledge_level) {
        this.id = id;
        this.id_profile = id_profile;
        this.id_skill = id_skill;
        this.skill_knowledge_level = skill_knowledge_level;
    }

    public ProfileSkills(int id_profile, int id_skill, int skill_knowledge_level) {
        this.id_profile = id_profile;
        this.id_skill = id_skill;
        this.skill_knowledge_level = skill_knowledge_level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public int getSkill_knowledge_level() {
        return skill_knowledge_level;
    }

    public void setSkill_knowledge_level(int skill_knowledge_level) {
        this.skill_knowledge_level = skill_knowledge_level;
    }
}