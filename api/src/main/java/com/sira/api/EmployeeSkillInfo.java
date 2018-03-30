package com.sira.api;

import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Employee;
import com.sira.model.stateschema.model.UserBase;

public class EmployeeSkillInfo extends DataAccess{

	private static Logger logger = Logger.getLogger(EmployeeSkillInfo.class);

	public EmployeeSkillInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Override
	public void Add(UserBase userBase) throws APIException {

		try {

			Employee employee = (Employee) userBase;

			for (int i = 0; i < employee.getSkills().size(); i++) {
				
				this.getEntitimanager().persist(employee.getSkills().get(i));
				
			}
			
			Employee empFound = this.getEmployee(employee);
			
			empFound.getSkills().addAll(employee.getSkills());

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getLocalizedMessage());
		}

	}

	
	@Override
	public void Update(UserBase userBase) throws APIException {

		try {

			Employee employee = (Employee) userBase;
			
			for (int i = 0; i < employee.getSkills().size(); i++) {

				this.getEntitimanager().persist(employee.getSkills().get(i));

			}
			
			Employee empFound = this.getEmployee(employee);

			empFound.getSkills().clear();

			empFound.getSkills().addAll(employee.getSkills());

			logger.info("________updated skill "+this.getGson().toJson(empFound));

			this.getEntitimanager().merge(empFound);

		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getLocalizedMessage());

		}
	}

	@Transactional
	@Override
	public void Delete(UserBase userBase) throws APIException {

		try {

			Employee employee = (Employee) userBase;

			Employee empFound = this.getEmployee(employee);

			empFound.getSkills().removeAll(employee.getSkills());
			
			this.getEntitimanager().merge(empFound);


		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getLocalizedMessage());

		}
	}

	@Transactional
	@Override
	public UserBase View(UserBase userBase) throws APIException {

		Employee employee;

		try {

			employee = (Employee) userBase;

			Employee empFound = this.getEmployee(employee);

			employee.setSkills(empFound.getSkills());


		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getLocalizedMessage());

		}

		return employee;
	}

}
