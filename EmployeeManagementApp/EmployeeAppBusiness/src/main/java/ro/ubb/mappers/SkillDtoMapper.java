package ro.ubb.mappers;

import ro.ubb.constants.TechnologyArea;
import ro.ubb.dtos.SkillDto;
import ro.ubb.models.Skill;

public class SkillDtoMapper {

    public static Skill mapSkillDtoToSkill(SkillDto skillDto) {
        Skill skill = new Skill();
        skill.setSkillName(skillDto.getSkillName());

        String technologyArea = skillDto.getTechnologyArea();
        for (TechnologyArea technologyArea1 : TechnologyArea.values()) {
            if (technologyArea.equals(technologyArea1.getTechnologyArea())) {
                skill.setTechnologyArea(technologyArea1);
            }
        }

        return skill;
    }

    public static SkillDto mapSkillToSkillDto(Skill skill) {
        SkillDto skillDto = new SkillDto();
        skillDto.setSkillName(skill.getSkillName());
        skillDto.setTechnologyArea(skill.getTechnologyArea().getTechnologyArea());

        return skillDto;
    }
}