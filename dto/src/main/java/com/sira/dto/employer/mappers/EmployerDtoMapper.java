
package com.sira.dto.employer.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employer.EmployerDto;
import com.sira.model.stateschema.model.Employer;

@Mapper
public interface EmployerDtoMapper {

	EmployerDtoMapper MAPPER = Mappers.getMapper( EmployerDtoMapper.class );

	Employer toEntity(EmployerDto employerDto);

	@InheritInverseConfiguration
	EmployerDto fromEntity(Employer employer);


}
