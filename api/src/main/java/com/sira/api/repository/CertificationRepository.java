package com.sira.api.repository;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.sira.api.repository.allquery.UplaancerQuery;
import com.sira.api.repository.error.UplancerException;
import com.sira.model.stateschema.employee.Certefication;

public class CertificationRepository extends Repository<Certefication> {
	
	private static Logger logger = Logger.getLogger(CertificationRepository.class);

	private RepositoryContext repositoryContext;

	public CertificationRepository(RepositoryContext repositoryContext) {

		this.repositoryContext = repositoryContext;
		
	}

	public RepositoryContext getRepositoryContext() {
		
		return this.repositoryContext;
	
	}

	@Override
	public Certefication getById(long id) throws UplancerException {

		Certefication res = null;
		
		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getaCerteficationQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("hjid", id);

			res = (Certefication) query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
		return res;

	}

	@Override
	public List<Certefication> getAll() throws UplancerException {

		List<Certefication> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getAllCerteficationQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			res = query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

		return res;
	
	}

	@Override
	public List<Certefication> getAllMaching(Certefication t) throws UplancerException {

		List<Certefication> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getMatchingAddresQuery());

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
	public void save(Certefication t) throws UplancerException {
		
		
	}

	@Override
	public void delete(Certefication t) throws UplancerException {

		try {

			this.getRepositoryContext().getEntityManager().remove(t);

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
	}

	@Override
	public void deleteMaching(Certefication t) throws UplancerException {
		
		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getDeleteMatchingCerteficationQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("hjid", t.getHjid());

			query.setParameter("name", t.getName());

			query.executeUpdate();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
	}
	
}
