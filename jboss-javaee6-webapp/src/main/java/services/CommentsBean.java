package services;


import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.xml.stream.events.Comment;

import models.Comments;

@Named
@Stateless
public class CommentsBean implements Serializable {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	public void register(Comments coment) throws Exception {
		em.persist(coment);
		log.info("dojde");
	}

	public List<Comments> commentView(String game) {
		List<Comments> scores = em.createQuery("Select s from Comments s where game =:game order by comment", Comments.class)
				.setParameter("game", game).setMaxResults(5).getResultList();
		return scores;
	}
}

