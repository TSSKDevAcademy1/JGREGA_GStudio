package services;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import javax.persistence.EntityManager;

import models.Regdata;

@Named
@Stateless
public class RegistrationBean {
	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	public void register(Regdata regdata) throws Exception {
		log.info("Registering " + regdata.getLogin());
		log.info("Registering " + regdata.getAge());
		log.info("Registering " + regdata.getCountry());
		log.info("Registering " + regdata.getPasswd());
		em.persist(regdata);
		log.info("dojde");

	}
}
