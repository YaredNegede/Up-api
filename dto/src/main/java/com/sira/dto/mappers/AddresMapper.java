package com.sira.dto.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employee.AddresDto;
import com.sira.dto.employee.JpaContext;
import com.sira.model.stateschema.model.Addres;

@Mapper
public interface AddresMapper {

	AddresMapper MAPPER = Mappers.getMapper( AddresMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	Addres toEntity(AddresDto s, @Context JpaContext ctx);

}
