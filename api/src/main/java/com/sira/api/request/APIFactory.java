package com.sira.api.request;

import java.util.HashMap;
import java.util.Map;

import com.sira.api.EmployeeInfo;
import com.sira.api.EmployerInfo;
import com.sira.api.ProjectInfo;
import com.sira.api.SkillInfo;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.Employer;
import com.sira.model.stateschema.model.Project;
import com.sira.model.stateschema.model.Skill;

public class APIFactory {

	private static Map<RequestEntity,Class<? extends Object>> mapping = new HashMap<RequestEntity,Class<? extends Object>>();
	
	private static Map<RequestEntity,Class<? extends Object>> entityMapping = new HashMap<RequestEntity,Class<? extends Object>>();

	public APIFactory() {

		mapping.put(RequestEntity.Employee, EmployeeInfo.class);
		
		mapping.put(RequestEntity.Employer, EmployerInfo.class);
		
		mapping.put(RequestEntity.Project, ProjectInfo.class);
		
		mapping.put(RequestEntity.Skill, SkillInfo.class);
		
	}
	
	public void initAPI() {

		mapping.put(RequestEntity.Employee, EmployeeInfo.class);
		
		mapping.put(RequestEntity.Employer, EmployerInfo.class);
		
		mapping.put(RequestEntity.Project, ProjectInfo.class);
		
		mapping.put(RequestEntity.Skill, SkillInfo.class);
		
	}
	
	public void initModels() {

		entityMapping.put(RequestEntity.Employee, Employee.class);
		
		entityMapping.put(RequestEntity.Employer, Employer.class);
		
		entityMapping.put(RequestEntity.Project, Project.class);
		
		entityMapping.put(RequestEntity.Skill, Skill.class);
		
	}

	public static Map<RequestEntity, Class<? extends Object>> getMapping() {
		
		return mapping;
		
	}

	public static Map<RequestEntity, Class<? extends Object>> getEntityMapping() {

		return entityMapping;
		
	}
	
}
