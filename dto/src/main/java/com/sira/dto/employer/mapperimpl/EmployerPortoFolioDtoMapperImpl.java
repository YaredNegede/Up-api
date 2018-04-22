package com.sira.dto.employer.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employer.EmployerPortoFolioDto;
import com.sira.dto.employer.mappers.EmployerPortoFolioDtoMapper;
import com.sira.model.stateschema.model.EmployerPortoFolio;
import com.sira.model.stateschema.model.EmployerProfile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:51:50+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class EmployerPortoFolioDtoMapperImpl implements EmployerPortoFolioDtoMapper {

    @Override
    public EmployerProfile toEntity(EmployerPortoFolioDto employerPortoFolio) {
        if ( employerPortoFolio == null ) {
            return null;
        }

        EmployerProfile employerProfile = new EmployerProfile();

        employerProfile.setName( employerPortoFolio.name );

        return employerProfile;
    }

    @Override
    public EmployerPortoFolioDto fromEntity(EmployerPortoFolio employerPortoFolioDto) {
        if ( employerPortoFolioDto == null ) {
            return null;
        }

        EmployerPortoFolioDto employerPortoFolioDto1 = new EmployerPortoFolioDto();

        employerPortoFolioDto1.name = employerPortoFolioDto.getName();

        return employerPortoFolioDto1;
    }
}
