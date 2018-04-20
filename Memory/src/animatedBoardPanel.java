import java.awt.Graphics;
import java.io.IOException;

import javax.swing.ImageIcon;

public class animatedBoardPanel extends boardPanel {
	private static final long serialVersionUID = -338009384746887567L;
	private int speed;
	private int nFrame;
	protected ImageIcon img_X;
	protected ImageIcon img_O;

	public animatedBoardPanel(String imgN, String imgX, String imgO, int speed, int nFrame) throws IOException {
		super(imgN, imgX, imgO);
		this.img_X = Utils.loadImage("_" + imgX);
		this.img_O = Utils.loadImage("_" + imgO);
		this.speed = speed;
		this.nFrame = nFrame;
	}

	public void paintComponent(Graphics g) {
		switch (state / 2) {
		case Constants.N:
			drawImage(g, imgN);
			break;
		case Constants.X:
			if (state % 2 == 0)
				insert(g, img_X, imgN);
			else
				slideDown(g, img_X, imgX);
			break;
		case Constants.O:
			if (state % 2 == 0)
				insert(g, img_O, imgN);
			else
				slideDown(g, img_O, imgO);
			break;
		}
	}

	public void insert(Graphics g, ImageIcon img, ImageIcon restart) {
		drawImage(g, img, restart, 0, nFrame / 2);
	}

	public void slideDown(Graphics g, ImageIcon img, int restart) {
		drawImage(g, img, restart, nFrame / 2, nFrame);
	}

	protected void drawImage(Graphics g, ImageIcon img, int restart, int start, int end) {
		(new Thread(new Runnable() {
			@Override
			public void run() {
				int frame;
				for (frame = start; frame < end; frame++) {
					drawImage(g, img, frame, nFrame);
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						break;
					}
					drawImage(g, restart);
				}
			}
		})).start();
	}

	protected void drawImage(Graphics g, ImageIcon img, int frame, int totFrame) {
		g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), 0, 0, img.getIconWidth(),
				(img.getIconHeight() / totFrame * (frame + 1)), img.getImageObserver());
	}
}
