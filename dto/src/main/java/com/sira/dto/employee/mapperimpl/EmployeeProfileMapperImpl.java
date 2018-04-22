package com.sira.dto.employee.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employee.EmployeeProfileDto;
import com.sira.dto.mappers.EmployeeProfileMapper;
import com.sira.model.stateschema.model.EmployeeProfile;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:10:56+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class EmployeeProfileMapperImpl implements EmployeeProfileMapper {

    @Override
    public EmployeeProfile toEntity(EmployeeProfileDto employeeProfileDto) {
        if ( employeeProfileDto == null ) {
            return null;
        }

        EmployeeProfile employeeProfile = new EmployeeProfile();

        employeeProfile.setHjid( employeeProfileDto.id );
        employeeProfile.setOnTime( employeeProfileDto.onTime );
        employeeProfile.setOnBudget( employeeProfileDto.onBudget );
        employeeProfile.setRepeatHire( employeeProfileDto.repeatHire );
        employeeProfile.setReviews( employeeProfileDto.reviews );
        employeeProfile.setStar( employeeProfileDto.star );
        employeeProfile.setTitle( employeeProfileDto.title );

        return employeeProfile;
    }

    @Override
    public EmployeeProfileDto fromEntity(EmployeeProfile employeeProfile) {
        if ( employeeProfile == null ) {
            return null;
        }

        EmployeeProfileDto employeeProfileDto = new EmployeeProfileDto();

        employeeProfileDto.id = employeeProfile.getHjid();
        employeeProfileDto.onTime = employeeProfile.getOnTime();
        employeeProfileDto.onBudget = employeeProfile.getOnBudget();
        employeeProfileDto.repeatHire = employeeProfile.getRepeatHire();
        employeeProfileDto.reviews = employeeProfile.getReviews();
        employeeProfileDto.star = employeeProfile.getStar();
        employeeProfileDto.title = employeeProfile.getTitle();

        return employeeProfileDto;
    }
}
