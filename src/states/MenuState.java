package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import graphics.Button;
import graphics.ButtonState;
import console.Main;

public class MenuState extends States {

	private Button[] buttons = {
			new Button(Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 4 + 175, 500, 50, "Start Game"),
			new Button(Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 4 + 250, 500, 50, "Exit Game") };
	// index 0 = start; index 1 = exit
	private int current = 0; // zeigt auf den ausgewählten Button
	private static Font font = new Font("arial", Font.PLAIN, 127);

	public MenuState() {

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

				States.setStates(new DifficultyState());
			}

			else if (buttons[1].getState() == ButtonState.SELECTED) {
				Main.theGame.setRunning(false);
			}
		}

	}

	@Override
	public void render(Graphics g) {
		// Background
		g.clearRect(0, 0, Main.theGame.getWidth(), Main.theGame.getHeight());
		// Text
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Tri Again", Main.theGame.getWidth() / 2 - 250, Main.theGame.getHeight() / 3);
		// Buttons
		buttons[0].render(g);
		buttons[1].render(g);

	}

}
