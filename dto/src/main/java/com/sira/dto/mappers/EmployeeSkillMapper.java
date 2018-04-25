package com.sira.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.common.SiraMapper;
import com.sira.dto.employee.SkillDto;
import com.sira.model.stateschema.model.Skill;

@Mapper
public interface EmployeeSkillMapper  extends SiraMapper{

	EmployeeSkillMapper MAPPER = Mappers.getMapper( EmployeeSkillMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	Skill toEntity(SkillDto skillDto);
	
	@InheritInverseConfiguration
	SkillDto fromEntity(Skill skill);
	
}
