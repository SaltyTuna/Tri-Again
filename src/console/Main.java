package console;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import graphics.Display;
import states.MenuState;
import states.States;

public class Main implements Runnable {

	// graphics
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	private int height, width;
	// input
	private KeyManager keyManager;
	// other
	private boolean running = false; // wird auf true gesetzt wenn das Spiel läuft
	public static Main theGame; // vereinfacht das bearbeiten von Variablen
	private Thread thread;

	public Main(int width, int height) {
		theGame = this;
		keyManager = new KeyManager();
		this.width = width;
		this.height = height;
	}

	public void start() {
		running = true;
		thread = new Thread(this);

		display = new Display(width, height);
		display.getFrame().addKeyListener(keyManager);
		States.setStates(new MenuState());

		thread.start();
	}

	public void render() {

		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();

		States.getState().render(g);

		g.dispose();
		bs.show();
	}

	public void tick() {
		keyManager.tick();
		States.getState().tick();
	}

	@Override
	public void run() {

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {

				tick();
				render();
				delta--;
			}
		}
		// wenn das Spiel verloren oder ein Exitbutton aktiviert wurde
		display.getFrame().setVisible(false);
		display.getFrame().dispose();

	}


	// getter & setter
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public Display getDisplay() {
		return display;
	}

	public Thread getThread() {
		return thread;
	}


	public void setRunning(boolean y) {
		running = y;

	}

}
