package com.sira.dto.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employee.EmployeeProfileDto;
import com.sira.dto.employee.JpaContext;
import com.sira.model.stateschema.model.EmployeeProfile;

@Mapper
public interface EmployeeProfileMapper {

	EmployeeProfileMapper MAPPER = Mappers.getMapper( EmployeeProfileMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	EmployeeProfile toEntity(EmployeeProfileDto s, @Context JpaContext ctx);

}
