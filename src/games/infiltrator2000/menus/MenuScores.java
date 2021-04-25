package games.infiltrator2000.menus;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import app.AppLoader;

public class MenuScores extends Menu {

	private int ID;

	public int getID() {
		return this.ID;
	}

	private List<Long> scores;

	public MenuScores(int ID) {
		super(11,500,200);
		this.ID = ID;
		selection = 10;
		readScores();
		loadScores();
		items[10] = "Quitter";
		nom = "Tableau des scores";
	}

	private void readScores() {
		String json = AppLoader.restoreData("/infiltrator2000/scores.json");
		List<Long> scores = new ArrayList<Long>();
		try {
			JSONArray array = new JSONArray(json);
			for (int i = 0, li = array.length(); i < li; ++i) {
				long score = array.getLong(i);
				scores.add(score);
			}
		} catch (JSONException error) {}
		this.scores = scores;
	}

	private void saveScores() {
		JSONArray array = new JSONArray();
		for (long score: this.scores) {
			array.put(score);
		}
		String json = array.toString();
		AppLoader.saveData("/infiltrator2000/scores.json", json);
	}

	public void addScore(long score) {
		int i = 0;
		int li = scores.size();
		while (i < li && scores.get(i) >= score) {
			++i;
		}
		scores.add(i, score);
		while (li >= 10) {
			scores.remove(li);
			--li;
		}
		loadScores();
		saveScores();
	}

	public void loadScores() {
		for (int i = 0, li = this.scores.size(); i < li; ++i) {
			items[i] = i + " : " + this.scores.get(i);
		}
		for (int i = this.scores.size(); i < 10; ++i) {
			items[i] = i + " : 0";
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ESCAPE){
			game.enterState(1 /* MenuPrincipal */, new FadeOutTransition(), new FadeInTransition());
		}
		super.keyPressed(key, c);
	}

	@Override
	public void execOption(){
		switch (selection) {
		case 10:
			game.enterState(1 /* MenuPrincipal */, new FadeOutTransition(),	new FadeInTransition());
			break;
		default:
			break;
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g){
		super.render(arg0, arg1, g);
	}

}
