package com.xabe.tutorial.ws.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xabe.tutorial.model.rest.Rest;
import com.xabe.tutorial.service.rest.RestEJB;
import com.xabe.tutorial.ws.BaseRest;

@Path("/rest")
@Stateless
public class RestWs extends BaseRest {

	@EJB
	private RestEJB restEJB;

	@PostConstruct
	public void init() {
		logger.info("Servicio rest");
	}
	

	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rest> getRest() {
		return restEJB.getAll();
	}
}
