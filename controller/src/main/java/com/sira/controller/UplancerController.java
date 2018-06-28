package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.common.UplancerDto;
/**
 * 
 * @author Yared Negede
 *
 */
@RestController("uplancerController")
@RequestMapping("/services/uplancer/")
public class UplancerController {

	private static Logger logger = Logger.getLogger(UplancerController.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UplancerDto getById(long id) {

		return null;
	}

	@RequestMapping( method = RequestMethod.GET)
	public List<UplancerDto> getAll(long userId) {

		return null;
	}

	@RequestMapping( method = RequestMethod.POST)
	public UplancerDto save(UplancerDto t) {
		return null;
	}

	@RequestMapping( method = RequestMethod.DELETE)
	public UplancerDto delete(UplancerDto t) {

		return null;
	}

}
