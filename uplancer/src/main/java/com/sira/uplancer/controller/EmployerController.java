package com.sira.uplancer.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.employer.EmployerDto;
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
@RequestMapping("/api/employer")
public class EmployerController {

	private static Logger logger = Logger.getLogger(EmployerController.class);

	@Autowired
	EmployerService employerService;

	@DeleteMapping(value = "/{employerId}")
	public void delete(@PathVariable Long employeeId) {

		logger.info("deleting employer "+employeeId);

		this.getEmployerService().delete(employeeId);

	}

	@GetMapping(value = "/")
	@ResponseBody
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

	@GetMapping(value = "/{employerId}")
	public EmployerDto getEmployer(@PathVariable long employerId) {

		logger.info("Inside getemployerId, returned: ");

		EmployerDto ret = new EmployerDto();
		
		return ret ;

	}

	@PostMapping
	public EmployerDto save(EmployerDto employer) {

		logger.info("saving "+employer);
		
//		EmployerMapperImpl i = new EmployerMapperImpl();

		employerService.save(new Employer());
		
		return employer;
		
	}

	public EmployerService getEmployerService() {

		return this.employerService;
	
	}

}
