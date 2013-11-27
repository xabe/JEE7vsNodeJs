package com.xabe.tutorial.service.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xabe.tutorial.model.rest.Rest;
import com.xabe.tutorial.service.Service;

@Stateless
public class RestEJB extends Service<Rest>{
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(RestEJB.class);

	@PersistenceContext(unitName="restUnit")
	private EntityManager entityManager;


	public void add(Rest t) {
		try
		{
		entityManager.persist(t);
		entityManager.flush();
		}catch(Exception e){
			LOGGER.error("Error al hacer la insercion : "+e.getMessage());
			e.printStackTrace();
		}
	}

	public void delete(Rest t) {
		t = entityManager.merge(t);
		entityManager.remove(t);
		entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Rest> getAll() {
		Query query = entityManager.createNamedQuery("Rest.findAll", Rest.class);
		return (List<Rest>) query.getResultList();
	}

	public Rest update(Rest t) {
		Rest rest = entityManager.merge(t);
		entityManager.flush();
		return rest;
	}

}
