import java.awt.Graphics;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class boardPanel extends JPanel {
	private int state;
	private ImageIcon imgX;
	private ImageIcon imgO;

	private static final int N = 0;
	private static final int X = 1;
	private static final int O = 2;

	public boardPanel(String imgX, String imgO) throws IOException {
		state = N;
		this.imgX = Utils.loadImage(imgX);
		this.imgO = Utils.loadImage(imgO);
	}

	public void set(int v) {
		state = v;
		setToolTipText("§" + v);
		repaint();
	}

	public void paintComponent(Graphics g) {
		switch (state) {
		case N:
			g.clearRect(0, 0, getWidth(), getHeight());
			break;
		case X:
			drawImage(g, imgX);
			break;
		case O:
			drawImage(g, imgO);
			break;
		}
	}

	private boolean drawImage(Graphics g, ImageIcon img) {
		return g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), 0, 0, img.getIconWidth(), img.getIconHeight(),
				img.getImageObserver());
	}
}
