package figuren;

import java.awt.Color;
import java.awt.Graphics;

import console.Main;
import states.GameState;

public class Spieler {

	private int[][][] xy = {
			{ { Main.theGame.getWidth() / 2 - 25, Main.theGame.getWidth() / 2 - 25, Main.theGame.getWidth() / 2 + 25 },
					{ Main.theGame.getHeight() / 2 - 25, Main.theGame.getHeight() / 2 + 25,
							Main.theGame.getHeight() / 2 } },
			{ { Main.theGame.getWidth() / 2 + 25, Main.theGame.getWidth() / 2 + 25, Main.theGame.getWidth() / 2 - 25 },
					{ Main.theGame.getHeight() / 2 - 25, Main.theGame.getHeight() / 2 + 25,
							Main.theGame.getHeight() / 2 } },
			{ { Main.theGame.getWidth() / 2 - 25, Main.theGame.getWidth() / 2 + 25, Main.theGame.getWidth() / 2 },
					{ Main.theGame.getHeight() / 2 + 25, Main.theGame.getHeight() / 2 + 25,
							Main.theGame.getHeight() / 2 - 25 } },
			{ { Main.theGame.getWidth() / 2 - 25, Main.theGame.getWidth() / 2 + 25, Main.theGame.getWidth() / 2 },
					{ Main.theGame.getHeight() / 2 - 25, Main.theGame.getHeight() / 2 - 25,
							Main.theGame.getHeight() / 2 + 25 }

			} };

	// private int[] rightY = { Main.theGame.getHeight() / 2 - 25,
	// Main.theGame.getHeight() / 2 + 25,
	// Main.theGame.getHeight() / 2 };
	// private int[] leftX = { Main.theGame.getWidth() / 2 + 25,
	// Main.theGame.getWidth() / 2 + 25,
	// Main.theGame.getWidth() / 2 - 25 };
	// private int[] leftY = { Main.theGame.getHeight() / 2 - 25,
	// Main.theGame.getHeight() / 2 + 25,
	// Main.theGame.getHeight() / 2 };
	// private int[] upX = { Main.theGame.getWidth() / 2 - 25,
	// Main.theGame.getWidth() / 2 - 25,
	// Main.theGame.getWidth() / 2 + 25 };
	// private int[] upY = { Main.theGame.getHeight() / 2 - 25,
	// Main.theGame.getHeight() / 2 + 25,
	// Main.theGame.getHeight() / 2 };
	// private int[] leftX = { Main.theGame.getWidth() / 2 + 25,
	// Main.theGame.getWidth() / 2 + 25,
	// Main.theGame.getWidth() / 2 - 25 };
	// private int[] leftY = { Main.theGame.getHeight() / 2 - 25,
	// Main.theGame.getHeight() / 2 + 25,
	// Main.theGame.getHeight() / 2 };

	private int direction; // 0 = rechts, 1 = links

	public Spieler() {
		direction = 0;

	}

	public void tick() {

		if (Main.theGame.getKeyManager().rightPressed) {
			direction = 0;
		}

		if (Main.theGame.getKeyManager().leftPressed) {
			direction = 1;
		}

		if (GameState.theGameState.getDifficulty() == 1) {
			if (Main.theGame.getKeyManager().upPressed) {
				direction = 2;
			}

			if (Main.theGame.getKeyManager().downPressed) {
				direction = 3;
			}
		}
	}

	public void render(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillPolygon(xy[direction][0], xy[direction][1], 3);

	}

	public int getDirection() {
		return direction;
	}

}
