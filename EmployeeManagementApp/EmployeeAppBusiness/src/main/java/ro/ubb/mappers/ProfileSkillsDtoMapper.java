package ro.ubb.mappers;

import ro.ubb.dtos.ProfileSkillDto;
import ro.ubb.models.ProfileSkills;

public class ProfileSkillsDtoMapper {
    public static ProfileSkills mapProfileSkillsDtoToProfileSkills(ProfileSkillDto profileSkillDto) {
        ProfileSkills profileSkills = new ProfileSkills();
        profileSkills.setId_profile(profileSkillDto.getId_profile());
        profileSkills.setId_skill(profileSkillDto.getId_skill());
        profileSkills.setSkill_knowledge_level(profileSkillDto.getSkill_knowledge_level());

        return profileSkills;
    }

    public static ProfileSkillDto mapProfileSkillsToProfileSkillsDto(ProfileSkills profileSkills) {
        ProfileSkillDto profileSkillDto = new ProfileSkillDto();
        profileSkillDto.setId_profile(profileSkills.getId_profile());
        profileSkillDto.setId_skill(profileSkills.getId_skill());
        profileSkillDto.setSkill_knowledge_level(profileSkills.getSkill_knowledge_level());

        return profileSkillDto;
    }
}