package com.sira.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.common.SiraMapper;
import com.sira.dto.employee.EmployeeProfileDto;
import com.sira.model.stateschema.employee.EmployeeProfile;

@Mapper
public interface EmployeeProfileMapper  extends SiraMapper{

	EmployeeProfileMapper MAPPER = Mappers.getMapper( EmployeeProfileMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	EmployeeProfile toEntity(EmployeeProfileDto employeeProfileDto);
	
	@InheritInverseConfiguration
	EmployeeProfileDto fromEntity(EmployeeProfile employeeProfile);
}
