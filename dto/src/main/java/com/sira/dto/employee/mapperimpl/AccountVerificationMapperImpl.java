package com.sira.dto.employee.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employee.AccountVerificationDto;
import com.sira.dto.mappers.AccountVerificationMapper;
import com.sira.model.stateschema.model.AccountVerification;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:10:56+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class AccountVerificationMapperImpl implements AccountVerificationMapper {

    @Override
    public AccountVerification toEntity(AccountVerificationDto accountVerificationDto) {
        if ( accountVerificationDto == null ) {
            return null;
        }

        AccountVerification accountVerification = new AccountVerification();

        accountVerification.setHjid( accountVerificationDto.id );
        accountVerification.setName( accountVerificationDto.name );
        accountVerification.setStatus( accountVerificationDto.status );

        return accountVerification;
    }

    @Override
    public AccountVerification fromEntity(AccountVerificationDto accountVerificationDto) {
        if ( accountVerificationDto == null ) {
            return null;
        }

        AccountVerification accountVerification = new AccountVerification();

        accountVerification.setName( accountVerificationDto.name );
        accountVerification.setStatus( accountVerificationDto.status );

        return accountVerification;
    }
}
