package com.sira.dto.employer.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employer.EmployerProfileDto;
import com.sira.dto.employer.mappers.EmployerProfileDtoMapper;
import com.sira.model.stateschema.model.EmployerProfile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:51:50+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class EmployerProfileDtoMapperImpl implements EmployerProfileDtoMapper {

    @Override
    public EmployerProfile toEntity(EmployerProfileDto employerProfileDto) {
        if ( employerProfileDto == null ) {
            return null;
        }

        EmployerProfile employerProfile = new EmployerProfile();

        employerProfile.setOnTime( employerProfileDto.onTime );
        employerProfile.setOnBudget( employerProfileDto.onBudget );
        employerProfile.setRepeatHire( employerProfileDto.repeatHire );
        employerProfile.setReviews( employerProfileDto.reviews );
        employerProfile.setStar( employerProfileDto.star );
        employerProfile.setTitle( employerProfileDto.title );

        return employerProfile;
    }

    @Override
    public EmployerProfileDto fromEntity(EmployerProfile employerProfileDto) {
        if ( employerProfileDto == null ) {
            return null;
        }

        EmployerProfileDto employerProfileDto1 = new EmployerProfileDto();

        employerProfileDto1.onTime = employerProfileDto.getOnTime();
        employerProfileDto1.onBudget = employerProfileDto.getOnBudget();
        employerProfileDto1.repeatHire = employerProfileDto.getRepeatHire();
        employerProfileDto1.reviews = employerProfileDto.getReviews();
        employerProfileDto1.star = employerProfileDto.getStar();
        employerProfileDto1.title = employerProfileDto.getTitle();

        return employerProfileDto1;
    }
}
