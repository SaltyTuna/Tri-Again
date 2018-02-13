package states;

import java.awt.Font;
import java.awt.Graphics;

import console.Main;
import graphics.Button;
import graphics.ButtonState;

public class EndState extends States {

	private Button[] buttons = {
			new Button(Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 4 + 175, 500, 50, "Tri Again?"),
			new Button(Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 4 + 250, 500, 50,
					"Return to Menu"),
			new Button(Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 4 + 325, 500, 50, "Exit Game") };

	private static Font font = new Font("arial", Font.PLAIN, 125);
	private static Font scoreFont = new Font("arial", Font.PLAIN, 20);

	private int current;

	public EndState() {

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

			if (buttons[0].getState() == ButtonState.SELECTED) {

				States.setStates(new GameState());
			}

			else if (buttons[1].getState() == ButtonState.SELECTED) {
				States.setStates(new MenuState());
			}

			else if (buttons[2].getState() == ButtonState.SELECTED) {
				Main.theGame.setRunning(false);
			}

		}

	}

	@Override
	public void render(Graphics g) {
		g.clearRect(0, 0, Main.theGame.getWidth(), Main.theGame.getHeight());
		g.setFont(font);
		g.drawString("ur mom gay", Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 3);
		g.setFont(scoreFont);
		g.drawString("Your score is: " + GameState.theGameState.getScore(), Main.theGame.getWidth() / 2 - 390,
				Main.theGame.getHeight() / 15);
		// Buttons
		buttons[0].render(g);
		buttons[1].render(g);
		buttons[2].render(g);
	}

}