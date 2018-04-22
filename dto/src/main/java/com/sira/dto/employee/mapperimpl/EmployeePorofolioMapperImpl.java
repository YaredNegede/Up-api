package com.sira.dto.employee.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employee.EmployeePortoFolioDto;
import com.sira.dto.mappers.EmployeePorofolioMapper;
import com.sira.model.stateschema.model.EmployerPortoFolio;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:10:56+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class EmployeePorofolioMapperImpl implements EmployeePorofolioMapper {

    @Override
    public EmployerPortoFolio toEntity(EmployeePortoFolioDto employeePortoFolioDto) {
        if ( employeePortoFolioDto == null ) {
            return null;
        }

        EmployerPortoFolio employerPortoFolio = new EmployerPortoFolio();

        employerPortoFolio.setHjid( employeePortoFolioDto.id );
        employerPortoFolio.setName( employeePortoFolioDto.name );

        return employerPortoFolio;
    }

    @Override
    public EmployeePortoFolioDto fromEntity(EmployerPortoFolio employerPortoFolio) {
        if ( employerPortoFolio == null ) {
            return null;
        }

        EmployeePortoFolioDto employeePortoFolioDto = new EmployeePortoFolioDto();

        employeePortoFolioDto.id = employerPortoFolio.getHjid();
        employeePortoFolioDto.name = employerPortoFolio.getName();

        return employeePortoFolioDto;
    }
}
