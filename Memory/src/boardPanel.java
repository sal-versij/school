import java.awt.Graphics;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class boardPanel extends JPanel {
	private static final long serialVersionUID = 3068810476355153278L;

	private int state;
	protected ImageIcon imgX;
	protected ImageIcon imgO;

	public boardPanel(String imgX, String imgO) throws IOException {
		state = Constants.N;
		this.imgX = Utils.loadImage(imgX);
		this.imgO = Utils.loadImage(imgO);
	}

	public void set(int v) {
		state = v;
		setToolTipText("@" + v);
		repaint();
	}

	public void paintComponent(Graphics g) {
		switch (state) {
		case Constants.N:
			g.clearRect(0, 0, getWidth(), getHeight());
			break;
		case Constants.X:
			drawImage(g, imgX);
			break;
		case Constants.O:
			drawImage(g, imgO);
			break;
		}
	}

	protected void drawImage(Graphics g, ImageIcon img) {
		g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), 0, 0, img.getIconWidth(), img.getIconHeight(),
				img.getImageObserver());
	}
}
