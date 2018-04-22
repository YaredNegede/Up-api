package com.sira.dto.employer.mapperimpl;

import javax.annotation.Generated;

import com.sira.dto.employer.EmployerReviewDto;
import com.sira.dto.employer.mappers.EmployerReviewDtoMapper;
import com.sira.model.stateschema.model.EmployerReview;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-04-23T00:51:50+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_161 (Oracle Corporation)"
)
public class EmployerReviewDtoMapperImpl implements EmployerReviewDtoMapper {

    @Override
    public EmployerReview toEntity(EmployerReviewDto employerReviewDto) {
        if ( employerReviewDto == null ) {
            return null;
        }

        EmployerReview employerReview = new EmployerReview();

        employerReview.setName( employerReviewDto.name );
        employerReview.setComment( employerReviewDto.comment );
        employerReview.setStar( employerReviewDto.star );
        employerReview.setCountry( employerReviewDto.country );
        employerReview.setCost( employerReviewDto.cost );

        return employerReview;
    }

    @Override
    public EmployerReviewDto fromEntity(EmployerReview employerReview) {
        if ( employerReview == null ) {
            return null;
        }

        EmployerReviewDto employerReviewDto = new EmployerReviewDto();

        employerReviewDto.name = employerReview.getName();
        employerReviewDto.comment = employerReview.getComment();
        employerReviewDto.star = employerReview.getStar();
        employerReviewDto.country = employerReview.getCountry();
        employerReviewDto.cost = employerReview.getCost();

        return employerReviewDto;
    }

}
