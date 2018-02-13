package console;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean leftDown, rightDown, upDown, downDown, enterDown, escDown; // true wenn Knopf gedrückt bleibt
	public boolean leftPressed, rightPressed, upPressed, downPressed, enterPressed, escPressed; // true wenn Knopf kurz gedrückt wurde
	
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		leftPressed = keys[KeyEvent.VK_LEFT] && !leftDown;
		rightPressed = keys[KeyEvent.VK_RIGHT] && !rightDown;
		upPressed = keys[KeyEvent.VK_UP] && !upDown;
		downPressed = keys[KeyEvent.VK_DOWN] && !downDown;
		enterPressed = keys[KeyEvent.VK_ENTER] && !enterDown;
		escPressed = keys[KeyEvent.VK_ESCAPE] && !escDown;
		
		leftDown = keys[KeyEvent.VK_LEFT];
		rightDown = keys[KeyEvent.VK_RIGHT];
		enterDown = keys[KeyEvent.VK_ENTER];
		upDown = keys[KeyEvent.VK_UP];
		downDown = keys[KeyEvent.VK_DOWN];
		escDown = keys[KeyEvent.VK_ESCAPE];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
