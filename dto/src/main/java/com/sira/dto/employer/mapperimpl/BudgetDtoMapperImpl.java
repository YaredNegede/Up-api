package com.sira.dto.employer.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employer.BudgetDto;
import com.sira.dto.employer.mappers.BudgetDtoMapper;
import com.sira.model.stateschema.model.Budget;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:51:50+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class BudgetDtoMapperImpl implements BudgetDtoMapper {

    @Override
    public Budget toEntity(BudgetDto budgetDto) {
        if ( budgetDto == null ) {
            return null;
        }

        Budget budget;

        switch ( budgetDto ) {
            case FIXED_PRICE: budget = Budget.FIXED_PRICE;
            break;
            case HOURLY_RATE: budget = Budget.HOURLY_RATE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + budgetDto );
        }

        return budget;
    }

    @Override
    public BudgetDto fromEntity(Budget budget) {
        if ( budget == null ) {
            return null;
        }

        BudgetDto budgetDto;

        switch ( budget ) {
            case FIXED_PRICE: budgetDto = BudgetDto.FIXED_PRICE;
            break;
            case HOURLY_RATE: budgetDto = BudgetDto.HOURLY_RATE;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + budget );
        }

        return budgetDto;
    }
}
