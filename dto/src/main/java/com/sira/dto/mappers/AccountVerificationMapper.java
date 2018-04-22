package com.sira.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employee.AccountVerificationDto;
import com.sira.model.stateschema.model.AccountVerification;

@Mapper
public interface AccountVerificationMapper {

	AccountVerificationMapper MAPPER = Mappers.getMapper( AccountVerificationMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	AccountVerification toEntity(AccountVerificationDto accountVerificationDto);
	
	@InheritInverseConfiguration
	AccountVerification fromEntity(AccountVerificationDto accountVerificationDto);
	
}
