package com.sira.dto.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employee.EmployeeDto;
import com.sira.dto.employee.JpaContext;
import com.sira.model.stateschema.model.Employee;

@Mapper
public interface EmployeeMapper {

	EmployeeMapper MAPPER = Mappers.getMapper( EmployeeMapper.class );

	@Mappings({
	        @Mapping(source = "firstName", target = "firstName"),
	        @Mapping(source = "middleName", target = "middleName"),
	        @Mapping(source = "lastName", target = "lastName"),
	        @Mapping(source = "addres", target = "addres"),
	        @Mapping(source = "account", target = "account"),
	        @Mapping(source = "profile", target = "profile"),
	        @Mapping(source = "id", target = "hjid")
	    })
    Employee toEntity(EmployeeDto s, @Context JpaContext ctx);

}
