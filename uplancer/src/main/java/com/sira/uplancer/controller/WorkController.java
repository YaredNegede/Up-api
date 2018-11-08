package com.sira.uplancer.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.common.WorkBaseDto;
/**
 * 
 * @author Yared Negede
 * @email yared@uplancer.io
 *
 */
@RestController("workController")
@RequestMapping("/api/Work")
public class WorkController {

	private static Logger logger = Logger.getLogger(WorkController.class);
	
	@GetMapping(value = "/{id}")
	public WorkBaseDto getById(long id) {
		
		return null;
	}

	@GetMapping
	public List<WorkBaseDto> getAll(long userId) {
		
		return null;
	}

	@PostMapping
	public WorkBaseDto save(WorkBaseDto t) {
		
		return null;
	}

	@DeleteMapping
	public WorkBaseDto delete(WorkBaseDto t) {
		
		return null;
	}

}
