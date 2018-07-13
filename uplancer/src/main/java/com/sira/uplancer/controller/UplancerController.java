package com.sira.uplancer.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.common.UplancerDto;
/**
 * 
 * @author Yared Negede
 *
 */
@RestController("uplancerController")
@RequestMapping("/api/uplancer")
public class UplancerController {

	private static Logger logger = Logger.getLogger(UplancerController.class);

	@GetMapping(value = "/{id}")
	public UplancerDto getById(long id) {

		return null;
	}

	@GetMapping
	public List<UplancerDto> getAll(long userId) {

		return null;
	}

	@PostMapping
	public UplancerDto save(UplancerDto t) {
		return null;
	}

	@DeleteMapping
	public UplancerDto delete(UplancerDto t) {

		return null;
	}

}
