package states;

import java.awt.Graphics;

import console.Main;


public abstract class States {

	private static States currentState = null;

	public static void setStates(States state) {
		currentState = state;
	}

	public static States getState() {
		return currentState;
	}

	// CLASS

	public Main game;

	public States() {
		
	}

	public abstract void tick();

	public abstract void render(Graphics g);

}
