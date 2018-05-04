import java.awt.Graphics;

import javax.swing.JPanel;

public class OminoPanel extends JPanel {
	private static final long serialVersionUID = 6776686596393934669L;
	private int errors;

	public OminoPanel() {
		super();
		reset();
	}

	public void update() {
		repaint();
	}

	public void error() {
		errors++;
		update();
	}

	public void reset() {
		errors = 0;
		update();
	}

	public boolean isDead() {
		return errors > 4;
	}

	public int getErrors() {
		return errors;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (errors) {
		case 0:
			g.drawLine(48, 65, 26, 98);
		case 1:
			g.drawLine(50, 65, 73, 98);
		case 2:
			g.drawLine(35, 44, 64, 44);
		case 3:
			g.drawLine(49, 37, 49, 65);
		case 4:
			g.drawArc(41, 20, 16, 16, 0, 360);
		default:
			g.drawLine(99, 99, 0, 99);
			g.drawLine(0, 99, 0, 0);
			g.drawLine(0, 0, 49, 0);
			g.drawLine(49, 0, 49, 21);
			g.drawLine(0, 83, 16, 99);
			g.drawLine(0, 16, 16, 0);
		}
	}
}
