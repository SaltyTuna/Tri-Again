package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import console.Main;
import graphics.Button;
import graphics.ButtonState;

public class DifficultyState extends States {
	private Button[] buttons = {
			new Button(Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 4 + 175, 500, 50, "Normal"),
			new Button(Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 4 + 250, 500, 50, "Hard") };
	private static Font font = new Font("arial", Font.PLAIN, 125);

	private int current;

	public DifficultyState() {
		buttons[0].setState(ButtonState.SELECTED);
	}

	@Override
	public void tick() {
		if (Main.theGame.getKeyManager().downPressed)
			if (current < buttons.length - 1) {
				buttons[current].setState(ButtonState.NORMAL);
				buttons[current + 1].setState(ButtonState.SELECTED);
				current++;

			}

		if (Main.theGame.getKeyManager().upPressed) {
			if (current > 0) {
				buttons[current].setState(ButtonState.NORMAL);
				buttons[current - 1].setState(ButtonState.SELECTED);
				current--;
			}
		}

		if (Main.theGame.getKeyManager().enterPressed) {

			GameState gameState = new GameState();

			if (buttons[0].getState() == ButtonState.SELECTED) {

				GameState.theGameState.setDifficulty(0);
			}

			else if (buttons[1].getState() == ButtonState.SELECTED) {

				GameState.theGameState.setDifficulty(1);
			}

			States.setStates(gameState);

		}
	}

	@Override
	public void render(Graphics g) {
		// Background
		g.clearRect(0, 0, Main.theGame.getWidth(), Main.theGame.getHeight());
		// Text
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Difficulty", Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 3);
		// Buttons
		buttons[0].render(g);
		buttons[1].render(g);

	}
}