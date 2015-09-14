package services;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import models.Score;

@Named
@Stateless
public class ScoreBean implements Serializable {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	public void register(Score score) throws Exception {
		em.persist(score);
		log.info("dojde");
	}

	public List<Score> ScoreView(String gamesis) {
		List<Score> scores = em.createQuery("Select s from Score s where game =:game order by time asc", Score.class)
				.setParameter("game", gamesis).setMaxResults(5).getResultList();
		return scores;
	}
}
