
package com.sira.dto.employer.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employer.EmployerProfileDto;
import com.sira.model.stateschema.model.EmployerProfile;

@Mapper
public interface EmployerProfileDtoMapper {

	EmployerProfileDtoMapper MAPPER = Mappers.getMapper( EmployerProfileDtoMapper.class );

	
	EmployerProfile toEntity(EmployerProfileDto employerProfileDto);

	@InheritInverseConfiguration
	EmployerProfileDto fromEntity(EmployerProfile employerProfileDto);

}
