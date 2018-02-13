package figuren;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import console.Main;
import states.GameState;

public class Gegner {

	private int x, y;
	private int size = 50;

	private Random r;
	private int direction; // 0 = spawnt rechts, 1 = spawnt links, 2 = spawnt oben, 3 = spawn unten
	private boolean inMiddle;

	public Gegner(int difficulty) {
		if (difficulty == 0) {
			inMiddle = false;
			r = new Random();
			direction = r.nextInt(1 + 1);
			if (direction == 0) {
				x = Main.theGame.getWidth() - 25;
				y = Main.theGame.getHeight() / 2 - size / 2;
			} else if (direction == 1) {
				x = 25;
				y = Main.theGame.getHeight() / 2 - size / 2;
			}
		} else if (difficulty == 1) {
			inMiddle = false;
			r = new Random();
			direction = r.nextInt(1 + 3);
			if (direction == 0) {
				x = Main.theGame.getWidth() - size / 2;
				y = Main.theGame.getHeight() / 2 - size / 2;
			} else if (direction == 1) {
				x = size / 2;
				y = Main.theGame.getHeight() / 2 - size / 2;
			} else if (direction == 2) {
				x = Main.theGame.getWidth() / 2  - size / 2;
				y = size / 2;
			} else if (direction == 3) {
				x = Main.theGame.getWidth()/ 2 - size / 2;;
				y = Main.theGame.getHeight() - 25;
			}
		}
	}

	public void tick() {
		if (direction == 0) {
			if (x > Main.theGame.getWidth() / 2 + 25 + 1) {
				x = x - GameState.theGameState.getVelocity();
			}

			else {
				inMiddle = true;
			}
		}

		else if (direction == 1) {
			if (x < Main.theGame.getWidth() / 2 - 25 - 1 - size) {
				x = x + GameState.theGameState.getVelocity();
			}

			else {
				inMiddle = true;

			}
		}

		else if (direction == 2) {
			if (y < Main.theGame.getHeight() / 2 - 25 - 1 - size ) {
				y = y + GameState.theGameState.getVelocity();
			}

			else {
				inMiddle = true;

			}
		}

		else if (direction == 3) {
			if (y > Main.theGame.getHeight() / 2 + 25 + 2 + 1) {
				y = y - GameState.theGameState.getVelocity();
			}

			else {
				inMiddle = true;

			}
		}


	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, size, size);
	}

	public boolean getInMiddle() {
		return inMiddle;
	}

	public int getDirection() {
		return direction;
	}
}
