package com.sira.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.sira.dto.common.WorkBaseDto;
/**
 * 
 * @author Yared
 *
 */
@Controller
public class WorkController  extends RequestController{

	private static Logger logger = Logger.getLogger(WorkController.class);
	
	public WorkBaseDto getById(long id) {
		
		return null;
	}


	public List<WorkBaseDto> getAll(long userId) {
		
		return null;
	}


	public List<WorkBaseDto> getAllMaching() {
		
		return null;
	}


	public WorkBaseDto save(WorkBaseDto t) {
		
		return null;
	}


	public WorkBaseDto delete(WorkBaseDto t) {
		
		return null;
	}


	public WorkBaseDto deleteMaching(WorkBaseDto t) {
		
		return null;
	}



}
