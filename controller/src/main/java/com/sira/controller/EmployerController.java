package com.sira.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sira.model.stateschema.employer.Employer;
import com.sira.service.EmployerService;


/**
 * ----------------------
 * -@author Yared Negede-
 * ----------------------
 * @param <EmployerMapperImpl>
 *
 */
@RestController("employerController")
@RequestMapping("/services/employer/")
public class EmployerController<EmployerDto> {

	private static Logger logger = Logger.getLogger(EmployerController.class);

	@Autowired
	EmployerService employerService;

	@RequestMapping(value = "/{employerId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long employeeId) {

		logger.info("deleting employer "+employeeId);

		this.getEmployerService().delete(employeeId);

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<EmployerDto> getEmployers() {

		Pageable pageable = null;
		Page<Employer> employers = this.getEmployerService().viewAll(pageable);

		List<EmployerDto> employerDtos = new ArrayList<>();

		employers.forEach(employer->{
			EmployerDto dto = null;
			boolean add = employerDtos.add(dto);
		});

		return employerDtos;
	}

	@RequestMapping(value = "/{employerId}", method = RequestMethod.GET)
	public EmployerDto getEmployer(@PathVariable long employerId,BindingResult res) {

		logger.info("Inside getemployerId, returned: ");

		if(res.hasErrors()) {

			logger.error("error found");

		}

//		EmployerDto ret = new EmployerDto();

		return null ;

	}

	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployerDto save(EmployerDto employer) {

		logger.info("saving "+employer);
		
//		EmployerMapperImpl i = new EmployerMapperImpl();

		employerService.save(new Employer());
		
		return employer;
		
	}

	public EmployerService getEmployerService() {

		return this.employerService;
	
	}

	public static void setLogger(Logger logger) {
		EmployerController.logger = logger;
	}

}
