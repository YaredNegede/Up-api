package com.sira.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.common.SiraMapper;
import com.sira.dto.employee.CerteficationDto;
import com.sira.model.stateschema.employee.Certefication;

@Mapper
public interface CerteficationMapper  extends SiraMapper{

	CerteficationMapper MAPPER = Mappers.getMapper( CerteficationMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	Certefication toEntity(CerteficationDto certeficationDto);

	@InheritInverseConfiguration
	CerteficationDto fromEntity(Certefication certefication);
}
