package com.sira.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.common.SiraMapper;
import com.sira.dto.employee.AddresDto;
import com.sira.model.stateschema.model.Addres;

@Mapper
public interface AddresMapper  extends SiraMapper{

	AddresMapper MAPPER = Mappers.getMapper( AddresMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	
	Addres toEntity(AddresDto addresDto);

	@InheritInverseConfiguration
	AddresDto fromEntity(Addres addres);
	
}
