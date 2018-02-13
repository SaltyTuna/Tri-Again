package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Button {

	private static Font font = new Font("arial", Font.PLAIN, 20);

	private int height, width;
	private int x, y;
	private String text;
	private ButtonState state;

	public Button(int x, int y, int width, int height, String text) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.text = text;
		this.state = ButtonState.NORMAL;
	}

	public void render(Graphics g) {
		if (state == ButtonState.NORMAL) {
			g.setFont(font);
			Rectangle2D rect = g.getFontMetrics().getStringBounds(text, g);

			
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
			g.drawString(text, x + width / 2 - (int) rect.getWidth() / 2, y + height / 2 + (int) rect.getHeight() / 2);
		}
		
		else if(state == ButtonState.SELECTED) {
			g.setFont(font);
			Rectangle2D rect = g.getFontMetrics().getStringBounds(text, g);

			g.setColor(Color.BLACK);
			g.fillRect(x, y, width, height);
			
			g.setColor(Color.WHITE);
			g.drawString(text, x + width / 2 - (int) rect.getWidth() / 2, y + height / 2 + (int) rect.getHeight() / 2);

		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ButtonState getState() {
		return state;
	}

	public String getText() {
		return text;
	}

	public void setState(ButtonState state) {
		this.state = state;
	}
}
