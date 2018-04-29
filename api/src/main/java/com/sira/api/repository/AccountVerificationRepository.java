package com.sira.api.repository;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.sira.api.repository.allquery.UplaancerQuery;
import com.sira.api.repository.error.UplancerException;
import com.sira.model.stateschema.common.AccountVerification;

public class AccountVerificationRepository extends Repository<AccountVerification> {

	private static Logger logger = Logger.getLogger(AccountVerificationRepository.class);

	private RepositoryContext repositoryContext;

	public AccountVerificationRepository(com.sira.api.repository.RepositoryContext repositoryContext) {

		this.repositoryContext = repositoryContext;
	}

	public RepositoryContext getRepositoryContext() {
		return repositoryContext;
	}

	@Override
	public AccountVerification getById(long id) throws UplancerException {

		AccountVerification res = null;
		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getaAcountVerificationQuery());

			query.setParameter("id", id);

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			res = (AccountVerification) query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		return res;

	}

	@Override
	public List<AccountVerification> getAll() throws UplancerException {

		List<AccountVerification> res = null;

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
	public List<AccountVerification> getAllMaching(AccountVerification accountVerification) throws UplancerException {

		List<AccountVerification> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getMatchingAcountVerificationQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("userId", accountVerification.getName());

			query.setParameter("hjid", accountVerification.getHjid());

			res = query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

		return res;
	}

	@Override
	public void save(AccountVerification t) throws UplancerException {

		try {

			this.getRepositoryContext().getEntityManager().persist(t);

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

	}

	@Override
	public void delete(AccountVerification t) throws UplancerException {

		try {

			this.getRepositoryContext().getEntityManager().remove(t);

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

	}

	@Override
	public void deleteMaching(AccountVerification t) throws UplancerException {

		List<AccountVerification> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getDleteMatchingAcountVerificationQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("userId", t.getName());

			query.setParameter("hjid", t.getHjid());

			query.executeUpdate();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
	}

}
