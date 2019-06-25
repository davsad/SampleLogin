package com.sample.login.jpa.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public abstract class PersistenceProvider {

	@PersistenceContext(name = "PersistenceService")
	protected EntityManager entityManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceProvider.class);

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public <T> void addEntity(final T entity) {
		LOGGER.debug("PERSISTENCE_LAYER: Add Entity : {} ", entityManager.toString());
		entityManager.persist(entity);
	}

	public <T> void updateEntity(final T entity) {
		LOGGER.debug("PERSISTENCE_LAYER: Update Entity : {} ", entity);
		entityManager.merge(entity);
		// throw new InvalidResponseDataException("Failed to update
		// entity");
	}

	public <T> T getEntity(final Class<T> entityClass, final long id) {
		LOGGER.debug("PERSISTENCE_LAYER: Get Entity By Id : {} ", entityClass, id);
		return (entityClass.cast(entityManager.find(entityClass, id)));
	}

	public <T> List<T> getEntities(final Class<T> entityClass) {
		LOGGER.debug("PERSISTENCE_LAYER: Get All Entities : {} ", entityClass);
		CriteriaBuilder criteriaBuilder = null;
		CriteriaQuery<T> criteriaQuery = null;
		Root<T> entity = null;
		TypedQuery<T> query = null;
		criteriaBuilder = entityManager.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(entityClass);
		criteriaQuery.select(entity);
		entity = criteriaQuery.from(entityClass);
		query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public <T> void deleteEntity(final Class<T> entityClass, final long id) {
		LOGGER.debug("PERSISTENCE_LAYER: Delete Entity by Class and Id : {}", entityClass, id);
		entityManager.remove(entityManager.find(entityClass, id));
	}
	
	@SuppressWarnings("all")
	public <T> List<T> findByAttribute(Class <T> entityClass, final String attribute, final Object value) {
		CriteriaBuilder criteriaBuilder = null;
		CriteriaQuery criteriaQuery = null;
		Root entity = null;
		TypedQuery query = null;
		criteriaBuilder = entityManager.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(entityClass);
		ParameterExpression param = criteriaBuilder.parameter(value.getClass());
		criteriaQuery.select(entity);
		entity = criteriaQuery.from(entityClass);
		criteriaQuery.where(criteriaBuilder.equal(entity.get(attribute), param));
		query = entityManager.createQuery(criteriaQuery);
		query.setParameter(param, value);
		return query.getResultList();
	}
	
	public void flush() {
		entityManager.flush();
	}
}
