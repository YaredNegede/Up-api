package com.sira.dto.employee.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employee.SkillDto;
import com.sira.dto.mappers.EmployeeSkillMapper;
import com.sira.model.stateschema.model.Skill;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:10:56+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class EmployeeSkillMapperImpl implements EmployeeSkillMapper {

    @Override
    public Skill toEntity(SkillDto skillDto) {
        if ( skillDto == null ) {
            return null;
        }

        Skill skill = new Skill();

        skill.setHjid( skillDto.id );
        skill.setName( skillDto.name );
        skill.setDescription( skillDto.description );

        return skill;
    }

    @Override
    public SkillDto fromEntity(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        SkillDto skillDto = new SkillDto();

        skillDto.id = skill.getHjid();
        skillDto.name = skill.getName();
        skillDto.description = skill.getDescription();

        return skillDto;
    }
}
