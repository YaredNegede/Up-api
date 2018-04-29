package com.sira.api.repository;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.sira.api.repository.allquery.UplaancerQuery;
import com.sira.api.repository.error.UplancerException;
import com.sira.model.stateschema.common.Account;
import com.sira.model.stateschema.employee.EmployeePortoFolio;

public class EmployeePortoFolioRepository extends Repository<EmployeePortoFolio>{
	
	private static Logger logger = Logger.getLogger(EmployeePortoFolioRepository.class);
	
	private RepositoryContext repositoryContext;

	public EmployeePortoFolioRepository(RepositoryContext repositoryContext) {

		this.repositoryContext = repositoryContext;
		
	}

	public RepositoryContext getRepositoryContext() {
		
		return this.repositoryContext;
	
	}


	@Override
	public EmployeePortoFolio getById(long id) throws UplancerException {

		EmployeePortoFolio res = null;
		
		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getaAcountQuery());

			query.setParameter("id", id);

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			res = (EmployeePortoFolio) query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		return res;

	

	}

	@Override
	public List<EmployeePortoFolio> getAll() throws UplancerException {

		List<EmployeePortoFolio> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getAllAcountVerificationQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			res = query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

		return res;
	
	}

	@Override
	public List<EmployeePortoFolio> getAllMaching(EmployeePortoFolio t) throws UplancerException {

		List<EmployeePortoFolio> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getMatchingAcountQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("name", t.getName());

			query.setParameter("hjid", t.getHjid());

			res = query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

		return res;
	
	}

	@Override
	public void save(EmployeePortoFolio t) throws UplancerException {


		try {

			this.getRepositoryContext().getEntityManager().persist(t);

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

	}

	@Override
	public void delete(EmployeePortoFolio t) throws UplancerException {

		try {

			this.getRepositoryContext().getEntityManager().remove(t);

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
	}

	@Override
	public void deleteMaching(EmployeePortoFolio t) throws UplancerException {
		
		List<EmployeePortoFolio> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getDeleteMatchingAcountQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("hjid", t.getHjid());

			query.setParameter("number", t.getName());

			query.executeUpdate();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
	}
	
}
