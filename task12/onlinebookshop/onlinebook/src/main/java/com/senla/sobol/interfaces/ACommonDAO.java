package com.senla.sobol.interfaces;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public abstract class ACommonDAO<T> {
	private Class<T> persistentClass;
	private Logger log = null;

	public ACommonDAO(Class<T> type) {
		this.persistentClass = type;
		log = Logger.getLogger(persistentClass.getName());
	}

	public abstract String getIdSearch();

	public List<T> getAll(Session session,String date) {
		try {
			CriteriaBuilder criteriabilder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteriaquerry = criteriabilder.createQuery(persistentClass);
			Root<T> root = criteriaquerry.from(persistentClass);
			criteriaquerry.select(root);
			if(date!=null){
				criteriaquerry.orderBy(criteriabilder.asc(root.get(date)));
			}
			TypedQuery<T> typedquerry = session.createQuery(criteriaquerry);
			List<T> list = typedquerry.getResultList();
			return list;
		} catch (NoResultException e) {
			log.error(e);
		}
		return null;

	}

	public T getID(Session session, Integer id) {
		try {
			CriteriaBuilder criteriabilder = session.getCriteriaBuilder();
			CriteriaQuery<T> criteriaquerry = criteriabilder.createQuery(persistentClass);
			Root<T> root = criteriaquerry.from(persistentClass);
			criteriaquerry.select(root);
			criteriaquerry.where(criteriabilder.equal(root.get(getIdSearch()), id));
			TypedQuery<T> typedquerry = session.createQuery(criteriaquerry);
			T t = typedquerry.getSingleResult();
			return t;
		} catch (NoResultException e) {
			log.error(e);
		}
		return null;
	}

	public void addNew(Session session, T t) {
		session.save(t);

	};

	public void delete(Session session, T t) {
		session.delete(t);

	};

	public void update(Session session, T t) {
		session.update(t);
	};

}
