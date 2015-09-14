package models;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Named
@Entity
@SessionScoped
public class Rate implements Serializable {

	@Id
	@GeneratedValue
	private long id;


	private String name;

	
	private String game;

	
	private String rate;

	
		public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

		public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}
}
