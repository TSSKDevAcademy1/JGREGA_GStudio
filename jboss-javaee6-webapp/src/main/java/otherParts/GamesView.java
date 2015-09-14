package otherParts;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class GamesView {

	private List<String> games;

	@PostConstruct
	public void init() {

		games = new ArrayList<String>();
		for (int i = 1; i <= 4; i++) {

			games.add("game" + i + "");

		}
	}

	public List<String> getGame() {
		return games;
	}
}
