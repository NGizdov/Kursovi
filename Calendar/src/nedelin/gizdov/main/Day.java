package nedelin.gizdov.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Day extends JComponent {

	private static final long serialVersionUID = 1L;
	private static final int DEF_POS_X = 0;
	private static final int DEF_POS_Y = 0;
	private static final int DEF_WIDTH = 70;
	private static final int DEF_HEIGHT = 70;
	private static final Color DEF_COLOR = Color.GREEN;

	private int posX;
	private int posY;
	private int width;
	private int height;
	private String name;

	private Color color;

	public Day(int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		setSize(this.width, this.height);
		setEnabled(true);
		setVisible(true);
		setFocusable(true);
		color = DEF_COLOR;
		setBounds(this.posX, this.posY, this.width, this.height);
		setOpaque(true);
	}

	public Day(int posX, int posY) {
		this(posX, posY, DEF_WIDTH, DEF_HEIGHT);
	}

	public Day() {
		this(DEF_POS_X, DEF_POS_Y);
	}

	public Day(String name) {
		this.name = name;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRoundRect(posX, posY, width, height, 20, 20);
		g.drawString(name, 25, 25);
	}

}
