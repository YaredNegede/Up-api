package com.sira.dto.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employee.AccountDto;
import com.sira.dto.employee.JpaContext;
import com.sira.model.stateschema.model.Account;

@Mapper
public interface AccountMapper {

	AccountMapper MAPPER = Mappers.getMapper( AccountMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	Account toEntity(AccountDto s, @Context JpaContext ctx);

}
