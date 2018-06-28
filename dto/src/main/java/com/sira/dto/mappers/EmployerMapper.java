package com.sira.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.common.SiraMapper;
import com.sira.dto.employer.EmployerDto;
import com.sira.model.stateschema.employer.Employer;

@Mapper
public interface EmployerMapper  extends SiraMapper{

	EmployerMapper MAPPER = Mappers.getMapper( EmployerMapper.class );


	@Mappings({
		@Mapping(source = "tradename",target="tradename"),
		@Mapping(source = "name", target = "name"),
		@Mapping(source = "phone", target = "phone"),
		@Mapping(source = "contact", target = "contact"),
		@Mapping(source = "id", target = "hjid")
	})
	Employer toEntity(EmployerDto employeeDto);

	@InheritInverseConfiguration
	EmployerDto fromEntity(Employer employer);
}
