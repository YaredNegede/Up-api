package com.sira.api;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.sira.api.error.APIException;
import com.sira.api.security.Security;
import com.sira.model.stateschema.model.Skill;
import com.sira.model.stateschema.model.UserBase;
/**
 * 
 * @author Yared
 *
 */
public class EmployeeSkillInfo extends DataAccess implements SkillAction{

	private static Logger logger = Logger.getLogger(EmployeeSkillInfo.class);

	public EmployeeSkillInfo(EntityManagerFactory entitimanager, Security security, String type) throws ClassNotFoundException {
		super(entitimanager, security,type);
	}

	@Transactional
	@Override
	public void Add(Skill skill) throws APIException {

		try {

			this.getEntitimanager().persist(skill);

		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getLocalizedMessage());
		}

	}

	@Transactional
	@Override
	public void Update(Skill skill) throws APIException {

		try {

			this.getEntitimanager().merge(skill);

		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getLocalizedMessage());

		}
	}

	@Transactional
	@Override
	public void Delete(Skill skill) throws APIException {

		try {

			this.getEntitimanager().remove(skill);


		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getLocalizedMessage());

		}
	}

	@Transactional
	@Override
	public Skill View(Skill skill) throws APIException {

		Skill skill2 = null;

		try {



		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getLocalizedMessage());

		}

		return skill2;
	}
	
	@Transactional
	@Override
	public List<Skill> ViewAll(Skill skill) throws APIException {

		List<Skill> skill2 = null;

		try {



		} catch (Exception e) {

			logger.error(e);

			throw new APIException(e.getLocalizedMessage());

		}

		return skill2;
	}

}
