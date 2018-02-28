package com.sira.api;

import javax.persistence.EntityManagerFactory;

import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.UserBase;

public class EmployeeInfo extends DataAccess{

	public EmployeeInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(UserBase userBase) throws APIException {

		try {
			
			Employee employee = (Employee) userBase;

			this.getEntitimanager().persist(employee);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(UserBase userBase) throws APIException {

		try {
			
			Employee employee = (Employee) userBase;
			
			this.getEntitimanager().merge(employee);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(UserBase userBase) throws APIException {

		try {
			
			Employee employee = (Employee) userBase;

			this.getEntitimanager().remove(employee);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
			
		}
	}

	@Override
	public UserBase View(UserBase userBase) throws APIException {
		
		Employee employee;
		
		try {

			employee = (Employee) userBase;

			employee = this.getEntitimanager().find(Employee.class, employee.getHjid());

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
			
		}

		return employee;
	}

}
