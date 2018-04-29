package com.sira.api.repository;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.sira.api.repository.allquery.UplaancerQuery;
import com.sira.api.repository.error.UplancerException;
import com.sira.model.stateschema.common.Addres;

public class AddresRepository extends Repository<Addres> {
	
	private static Logger logger = Logger.getLogger(AddresRepository.class);
	
	private RepositoryContext repositoryContext;

	public AddresRepository(RepositoryContext repositoryContext) {

		this.repositoryContext = repositoryContext;
		
	}

	public RepositoryContext getRepositoryContext() {
		
		return repositoryContext;
	
	}

	@Override
	public Addres getById(long id) throws UplancerException {

		Addres res = null;
		
		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getaAddresQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("hjid", id);

			res = (Addres) query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		return res;

	

	
		
	}

	@Override
	public List<Addres> getAll() throws UplancerException {

		List<Addres> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getAllAddresQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			res = query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

		return res;
	
	}

	@Override
	public List<Addres> getAllMaching(Addres t) throws UplancerException {

		List<Addres> res = null;

		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getMatchingAddresQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("number", t.getPhone());

			query.setParameter("hjid", t.getHjid());

			res = query.getResultList();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

		return res;
	
	}

	@Override
	public void save(Addres t) throws UplancerException {

		try {

			this.getRepositoryContext().getEntityManager().persist(t);

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}

	
		
	}

	@Override
	public void delete(Addres t) throws UplancerException {

		try {

			this.getRepositoryContext().getEntityManager().remove(t);

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
	}

	@Override
	public void deleteMaching(Addres t) throws UplancerException {
		
		try {

			Query query = this.getRepositoryContext().getEntityManager()
					.createNamedQuery(UplaancerQuery.getDeleteMatchingAcountQuery());

			query.setParameter("userId", this.getRepositoryContext().getUserBase().getHjid());

			query.setParameter("hjid", t.getHjid());

			query.setParameter("number", t.getPhone());

			query.executeUpdate();

		} catch (Exception e) {

			logger.error(e);

			throw new UplancerException(e.getLocalizedMessage());

		}
		
			
		
	}

	
}