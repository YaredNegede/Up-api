package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sira.dto.common.UplancerDto;
/**
 * 
 * @author Yared Negede
 *
 */
@RestController
@RequestMapping("/uplancerController")
public class UplancerController   extends RequestController{

	private static Logger logger = Logger.getLogger(UplancerController.class);
	
	
	public UplancerDto getById(long id) {
		
		return null;
	}

	public List<UplancerDto> getAll(long userId) {
		
		return null;
	}

	public List<UplancerDto> getAllMaching() {
		
		return null;
	}

	public UplancerDto save(UplancerDto t) {
		return null;
	}

	public UplancerDto delete(UplancerDto t) {
		
		return null;
	}

	public UplancerDto deleteMaching(UplancerDto t) {
		
		return null;
	}
	
}
