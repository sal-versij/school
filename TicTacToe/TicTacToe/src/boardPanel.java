import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JPanel;

public class boardPanel extends JPanel {
	private int state;
	private Image imgX;
	private Image imgO;

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
			imgX.flush();
			g.drawImage(imgX, 0, 0, null);
			System.out.println(imgX);
			System.out.println(imgX.getHeight(null));
			System.out.println(imgX.getWidth(null));
			break;
		case O:
			g.drawImage(imgO, 0, 0, null);
			break;
		}
	}
}
