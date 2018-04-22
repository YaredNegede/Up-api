
package com.sira.dto.employer.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sira.dto.employer.BudgetDto;
import com.sira.model.stateschema.model.Budget;

@Mapper
public interface BudgetDtoMapper {
	 
	BudgetDtoMapper MAPPER = Mappers.getMapper( BudgetDtoMapper.class );
	
	Budget toEntity(BudgetDto budgetDto);

	@InheritInverseConfiguration
	BudgetDto fromEntity(Budget budget);

}
