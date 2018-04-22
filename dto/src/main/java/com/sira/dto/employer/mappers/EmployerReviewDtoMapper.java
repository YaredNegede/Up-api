
package com.sira.dto.employer.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employer.EmployerReviewDto;
import com.sira.model.stateschema.model.EmployerReview;

@Mapper
public interface EmployerReviewDtoMapper {

	EmployerReviewDtoMapper MAPPER = Mappers.getMapper( EmployerReviewDtoMapper.class );


	EmployerReview toEntity(EmployerReviewDto employerReviewDto);

	@InheritInverseConfiguration
	EmployerReviewDto fromEntity(EmployerReview employerReview);

}
