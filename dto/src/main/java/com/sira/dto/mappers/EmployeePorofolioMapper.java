package com.sira.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.common.SiraMapper;
import com.sira.dto.employee.EmployeePortoFolioDto;
import com.sira.model.stateschema.employer.EmployerPortoFolio;

@Mapper
public interface EmployeePorofolioMapper  extends SiraMapper{

	EmployeePorofolioMapper MAPPER = Mappers.getMapper( EmployeePorofolioMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	EmployerPortoFolio toEntity(EmployeePortoFolioDto employeePortoFolioDto);
	
	@InheritInverseConfiguration
	EmployeePortoFolioDto fromEntity(EmployerPortoFolio employerPortoFolio);
}
