package com.sira.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.common.SiraMapper;
import com.sira.dto.employee.EmployeeDto;
import com.sira.model.stateschema.model.Employee;

@Mapper
public interface EmployeeMapper  extends SiraMapper{

	EmployeeMapper MAPPER = Mappers.getMapper( EmployeeMapper.class );

	@Mappings({
	        @Mapping(source = "firstName", target = "firstName"),
	        @Mapping(source = "middleName", target = "middleName"),
	        @Mapping(source = "lastName", target = "lastName"),
	        @Mapping(source = "id", target = "hjid")
	    })
    Employee toEntity(EmployeeDto employeeDto);
	
	@InheritInverseConfiguration
	EmployeeDto fromEntity(Employee employee);
}
