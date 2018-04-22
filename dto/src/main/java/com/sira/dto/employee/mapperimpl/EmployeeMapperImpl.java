package com.sira.dto.employee.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employee.EmployeeDto;
import com.sira.dto.mappers.EmployeeMapper;
import com.sira.model.stateschema.model.Employee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:10:56+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setFirstName( employeeDto.firstName );
        employee.setLastName( employeeDto.lastName );
        employee.setMiddleName( employeeDto.middleName );
        employee.setHjid( employeeDto.id );

        return employee;
    }

    @Override
    public EmployeeDto fromEntity(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.firstName = employee.getFirstName();
        employeeDto.lastName = employee.getLastName();
        employeeDto.middleName = employee.getMiddleName();
        employeeDto.id = employee.getHjid();

        return employeeDto;
    }
}
