package com.sira.dto.employee;

import java.util.List;

public class EmployeeDto {

	public Long id;
    public String firstName;
    public String middleName;
    public String lastName;
    public AddresDto addres;
    public AccountDto account;
    public EmployeeProfileDto profile;
    
    public List<CerteficationDto> certefication;
    public List<AccountVerificationDto> verification;
    public List<EmployeeReviewDto> reviews;
    public List<EmployeePortoFolioDto> employeePortoFolio;
    public List<SkillDto> skills;
    
}
