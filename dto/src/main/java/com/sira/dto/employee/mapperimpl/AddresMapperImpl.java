package com.sira.dto.employee.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employee.AddresDto;
import com.sira.dto.mappers.AddresMapper;
import com.sira.model.stateschema.model.Addres;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:10:56+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class AddresMapperImpl implements AddresMapper {

    @Override
    public Addres toEntity(AddresDto addresDto) {
        if ( addresDto == null ) {
            return null;
        }

        Addres addres = new Addres();

        addres.setHjid( addresDto.id );
        addres.setZip( addresDto.zip );
        addres.setPostalCode( addresDto.postalCode );
        addres.setCountry( addresDto.country );
        addres.setOffice( addresDto.office );
        addres.setPhone( addresDto.phone );

        return addres;
    }

    @Override
    public AddresDto fromEntity(Addres addres) {
        if ( addres == null ) {
            return null;
        }

        AddresDto addresDto = new AddresDto();

        addresDto.id = addres.getHjid();
        addresDto.zip = addres.getZip();
        addresDto.postalCode = addres.getPostalCode();
        addresDto.country = addres.getCountry();
        addresDto.office = addres.getOffice();
        addresDto.phone = addres.getPhone();

        return addresDto;
    }
}
