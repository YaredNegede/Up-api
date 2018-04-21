package com.sira.dto.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employee.JpaContext;
import com.sira.dto.employee.SkillDto;
import com.sira.model.stateschema.model.Skill;

@Mapper
public interface EmployeeSkillMapper {

	EmployeeSkillMapper MAPPER = Mappers.getMapper( EmployeeSkillMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	Skill toEntity(SkillDto s, @Context JpaContext ctx);

}
