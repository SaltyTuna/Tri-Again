package states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import console.Main;
import figuren.Gegner;
import figuren.Spieler;

public class GameState extends States {

	public static GameState theGameState;

	private Spieler player = new Spieler();
	private ArrayList<Gegner> gegner = new ArrayList<Gegner>();

	private int velocity = 8;
	private int spawnTimer;
	private static int difficulty;

	// Anzeigen/Graphics
	private int score;
	private String text;
	private Rectangle2D rect;

	private static Font scoreFont = new Font("arial", Font.PLAIN, 30);

	private PauseState pauseState = new PauseState();

	public GameState() {
		theGameState = this;
	}


	public void tick() {

		if (Main.theGame.getKeyManager().escPressed) {
			pauseState.saveGame(this);
			States.setStates(pauseState);
		}
		
		player.tick();

		if (spawnTimer == 20) {
			gegner.add(new Gegner(difficulty));
			spawnTimer = 0;
		} else {
			spawnTimer++;
		}

		for (int i = 0; i < gegner.size(); i++) {

			if (!gegner.get(i).getInMiddle()) {
				gegner.get(i).tick();
			} else {

				if (gegner.get(i).getDirection() == player.getDirection()) {
					gegner.remove(i);
					score++;
				} else {
					States.setStates(new EndState());
				}
			}
		}

	}

	@Override
	public void render(Graphics g) {

		g.clearRect(0, 0, Main.theGame.getWidth(), Main.theGame.getHeight());

		g.setFont(scoreFont);
		text = "Score: " + score;
		rect = g.getFontMetrics().getStringBounds(text, g);
		g.drawString(text, Main.theGame.getWidth() / 5 - (int) rect.getWidth() / 2, Main.theGame.getHeight() / 8);
		text = "Velocity: " + velocity;
		rect = g.getFontMetrics().getStringBounds(text, g);
		g.drawString(text, (Main.theGame.getWidth() / 5) * 4 - (int) rect.getWidth() / 2, Main.theGame.getHeight() / 8);

		player.render(g);
		for (int i = 0; i < gegner.size(); i++)
			gegner.get(i).render(g);

	}

	public Spieler getPlayer() {
		return player;
	}

	public int getScore() {
		return score;
	}

	public int getVelocity() {
		return velocity;
	}
	
	public int getDifficulty() {
		return difficulty;
	}

	public void addScore(int score) {
		this.score = this.score + score;
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

}
