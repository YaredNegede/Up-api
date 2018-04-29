package com.sira.api.repository;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.sira.api.repository.allquery.UplaancerQuery;
import com.sira.api.repository.error.UplancerException;
import com.sira.model.stateschema.common.Account;

public class AccountRepository extends Repository<Account>{
	
	private static Logger logger = Logger.getLogger(AccountRepository.class);
	
	private RepositoryContext repositoryContext;

	public AccountRepository(RepositoryContext repositoryContext) {
	
		this.repositoryContext = repositoryContext;
	
	}

	public RepositoryContext getRepositoryContext() {

		return repositoryContext;
	
	}

	@Override
	public Account getById(long id) throws UplancerException {

		Account res = null;
		
		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getaAcountQuery());

			query.setParameter("id", id);

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			res = (Account) query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		return res;

	

	}

	@Override
	public List<Account> getAll() throws UplancerException {

		List<Account> res = null;

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
	public List<Account> getAllMaching(Account t) throws UplancerException {

		List<Account> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getMatchingAcountQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("number", t.getNumber());

			query.setParameter("hjid", t.getHjid());

			res = query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

		return res;
	
	}

	@Override
	public void save(Account t) throws UplancerException {


		try {

			this.getRepositoryContext().getEntityManager().persist(t);

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

	}

	@Override
	public void delete(Account t) throws UplancerException {

		try {

			this.getRepositoryContext().getEntityManager().remove(t);

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
	}

	@Override
	public void deleteMaching(Account t) throws UplancerException {
		
		List<Account> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getDeleteMatchingAcountQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("hjid", t.getHjid());

			query.setParameter("number", t.getNumber());

			query.executeUpdate();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
	}
	
}