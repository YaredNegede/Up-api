
package com.sira.dto.employer.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employer.EmployerPortoFolioDto;
import com.sira.model.stateschema.model.EmployerPortoFolio;
import com.sira.model.stateschema.model.EmployerProfile;

@Mapper
public interface EmployerPortoFolioDtoMapper {

	EmployerPortoFolioDtoMapper MAPPER = Mappers.getMapper( EmployerPortoFolioDtoMapper.class );



	EmployerProfile toEntity(EmployerPortoFolioDto employerPortoFolio);

	@InheritInverseConfiguration
	EmployerPortoFolioDto fromEntity(EmployerPortoFolio employerPortoFolioDto);


}
