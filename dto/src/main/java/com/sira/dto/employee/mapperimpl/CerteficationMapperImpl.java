package com.sira.dto.employee.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employee.CerteficationDto;
import com.sira.dto.mappers.CerteficationMapper;
import com.sira.model.stateschema.model.Certefication;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:10:56+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class CerteficationMapperImpl implements CerteficationMapper {

    @Override
    public Certefication toEntity(CerteficationDto certeficationDto) {
        if ( certeficationDto == null ) {
            return null;
        }

        Certefication certefication = new Certefication();

        certefication.setHjid( certeficationDto.id );
        certefication.setName( certeficationDto.name );
        certefication.setScore( certeficationDto.score );

        return certefication;
    }

    @Override
    public CerteficationDto fromEntity(Certefication certefication) {
        if ( certefication == null ) {
            return null;
        }

        CerteficationDto certeficationDto = new CerteficationDto();

        certeficationDto.id = certefication.getHjid();
        certeficationDto.name = certefication.getName();
        certeficationDto.score = certefication.getScore();

        return certeficationDto;
    }
}
