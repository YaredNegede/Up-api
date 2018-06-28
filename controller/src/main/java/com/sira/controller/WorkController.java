package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.common.WorkBaseDto;
/**
 * 
 * @author Yared Negede
 * @email yared@uplancer.io
 *
 */
@RestController("workController")
@RequestMapping("/services/Work/")
public class WorkController {

	private static Logger logger = Logger.getLogger(WorkController.class);
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public WorkBaseDto getById(long id) {
		
		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<WorkBaseDto> getAll(long userId) {
		
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public WorkBaseDto save(WorkBaseDto t) {
		
		return null;
	}

	@RequestMapping( method = RequestMethod.DELETE)
	public WorkBaseDto delete(WorkBaseDto t) {
		
		return null;
	}

}
