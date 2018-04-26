package com.sira.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.common.SiraMapper;
import com.sira.dto.employee.EmployeeReviewDto;
import com.sira.model.stateschema.employer.EmployerReview;

@Mapper
public interface EmployeeReviewMapper  extends SiraMapper{

	EmployeeReviewMapper MAPPER = Mappers.getMapper( EmployeeReviewMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	EmployerReview toEntity(EmployeeReviewDto employeeReviewDto);
	
	@InheritInverseConfiguration
	EmployeeReviewDto fromEntity(EmployerReview employerReview);
}
