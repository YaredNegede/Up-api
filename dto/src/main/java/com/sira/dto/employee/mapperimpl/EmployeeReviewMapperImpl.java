package com.sira.dto.employee.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employee.EmployeeReviewDto;
import com.sira.dto.mappers.EmployeeReviewMapper;
import com.sira.model.stateschema.model.EmployerReview;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:10:56+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class EmployeeReviewMapperImpl implements EmployeeReviewMapper {

    @Override
    public EmployerReview toEntity(EmployeeReviewDto employeeReviewDto) {
        if ( employeeReviewDto == null ) {
            return null;
        }

        EmployerReview employerReview = new EmployerReview();

        employerReview.setHjid( employeeReviewDto.id );
        employerReview.setName( employeeReviewDto.name );
        employerReview.setComment( employeeReviewDto.comment );
        employerReview.setStar( employeeReviewDto.star );
        employerReview.setCountry( employeeReviewDto.country );
        employerReview.setCost( employeeReviewDto.cost );

        return employerReview;
    }

    @Override
    public EmployeeReviewDto fromEntity(EmployerReview employerReview) {
        if ( employerReview == null ) {
            return null;
        }

        EmployeeReviewDto employeeReviewDto = new EmployeeReviewDto();

        employeeReviewDto.id = employerReview.getHjid();
        employeeReviewDto.name = employerReview.getName();
        employeeReviewDto.comment = employerReview.getComment();
        employeeReviewDto.star = employerReview.getStar();
        employeeReviewDto.country = employerReview.getCountry();
        employeeReviewDto.cost = employerReview.getCost();

        return employeeReviewDto;
    }
}
