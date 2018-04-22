package com.sira.dto.employer.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employer.EmployerDto;
import com.sira.dto.employer.mappers.EmployerDtoMapper;
import com.sira.model.stateschema.model.Employer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:51:50+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class EmployerDtoMapperImpl implements EmployerDtoMapper {

    @Override
    public Employer toEntity(EmployerDto employerDto) {
        if ( employerDto == null ) {
            return null;
        }

        Employer employer = new Employer();

        employer.setName( employerDto.name );
        employer.setPhone( employerDto.phone );
        employer.setContact( employerDto.contact );
        employer.setTradename( employerDto.tradename );
        employer.setAddres( employerDto.addres );
        employer.setAccount( employerDto.account );

        return employer;
    }

    @Override
    public EmployerDto fromEntity(Employer employer) {
        if ( employer == null ) {
            return null;
        }

        EmployerDto employerDto = new EmployerDto();

        employerDto.name = employer.getName();
        employerDto.phone = employer.getPhone();
        employerDto.contact = employer.getContact();
        employerDto.tradename = employer.getTradename();
        employerDto.addres = employer.getAddres();
        employerDto.account = employer.getAccount();

        return employerDto;
    }
}
