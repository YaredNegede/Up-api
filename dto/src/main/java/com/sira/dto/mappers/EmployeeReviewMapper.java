package com.sira.dto.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employee.EmployeeReviewDto;
import com.sira.dto.employee.JpaContext;
import com.sira.model.stateschema.model.EmployerReview;

@Mapper
public interface EmployeeReviewMapper {

	EmployeeReviewMapper MAPPER = Mappers.getMapper( EmployeeReviewMapper.class );
	@Mappings({
        @Mapping(source = "id", target = "hjid")
    })
	EmployerReview toEntity(EmployeeReviewDto s, @Context JpaContext ctx);

}
