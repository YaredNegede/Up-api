package com.sira.api;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.UserBase;

public class EmployeeProfileInfo extends DataAccess{

	public EmployeeProfileInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(UserBase userBase) throws APIException {

		try {
			
			Employee employee = (Employee) userBase;

			Employee empFound = this.getEmployee(employee);

			empFound.getProfile().addAll(employee.getProfile());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Override
	public void Update(UserBase userBase) throws APIException {

		try {

			Employee employee = (Employee) userBase;

			Employee empFound = this.getEmployee(employee);

			empFound.getProfile().clear();
			
			empFound.getProfile().addAll(employee.getProfile());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public void Delete(UserBase userBase) throws APIException {

		try {
			
			Employee employee = (Employee) userBase;

			Employee empFound = this.getEmployee(employee);
			
			empFound.getProfile().removeAll(employee.getProfile());
			
			this.getEntitimanager().merge(empFound);
			

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());
		}
	}

	@Override
	public UserBase View(UserBase userBase) throws APIException {

		Employee employee;

		try {

			employee = (Employee) userBase;

			Employee emp = this.getEmployee(employee);
			
			employee.setProfile(emp.getProfile());
			

		} catch (Exception e) {

			throw new APIException(e.getLocalizedMessage());

		}

		return employee;
	}

}
