package com.sira.dto.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employee.CerteficationDto;
import com.sira.dto.employee.JpaContext;
import com.sira.model.stateschema.model.Certefication;

@Mapper
public interface CerteficationMapper {

	CerteficationMapper MAPPER = Mappers.getMapper( CerteficationMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	Certefication toEntity(CerteficationDto s, @Context JpaContext ctx);

}
