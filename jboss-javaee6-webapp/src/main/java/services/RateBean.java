package services;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import models.Rate;

@SuppressWarnings("serial")
@Named
@Stateless
public class RateBean implements Serializable {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;
	
	private double scores;

	public void register(Rate rate) throws Exception {
		em.persist(rate);
		log.info("dojde");
	}

	public double rateView(String game) throws SQLException {
		try{
		scores = em.createQuery("Select AVG(rate) from Rate s where game =:game", Double.class) /// dorobit
				.setParameter("game", game).getSingleResult();
		}catch(Exception e){
			scores = 0;
		}
		System.out.println(scores);
		return scores;
	}
}
