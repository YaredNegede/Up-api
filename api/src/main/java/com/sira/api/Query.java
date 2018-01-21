package com.sira.api;

public abstract class Query {

	private String allEmployee = "from Employee";	
	private String allEmployer = "from Employer";	
	private String allProject = "from Project";
	private String allSkill = "from Skill";
	
	private String employeeProject = "from Project as p where p.name=";	
	private String employeeSkill = "from Skill as s where s.name=";
	private String employeeProfile = "from Profile as p where p.name=";
	
	private String employerProject = "from Project as p where p.name=";	
	private String employerSkill = "from Skill as s where s.name=";
	private String employerProfile = "from Profile as p where p.name=";
	
	public String getAllEmployee() {
		return allEmployee;
	}
	public String getAllEmployer() {
		return allEmployer;
	}
	public String getAllProject() {
		return allProject;
	}
	public String getAllSkill() {
		return allSkill;
	}
	public String getEmployeeProject() {
		return employeeProject;
	}
	public String getEmployeeSkill() {
		return employeeSkill;
	}
	public String getEmployeeProfile() {
		return employeeProfile;
	}
	public String getEmployerProject() {
		return employerProject;
	}
	public String getEmployerSkill() {
		return employerSkill;
	}
	public String getEmployerProfile() {
		return employerProfile;
	}
	
}
