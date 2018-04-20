import java.awt.Graphics;
import java.io.IOException;

import javax.swing.ImageIcon;

public class animatedBoardPanel extends boardPanel {
	private static final long serialVersionUID = -338009384746887567L;
	private Runnable animator;
	private int speed;
	private int nFrame;

	public animatedBoardPanel(String imgX, String imgO, int speed, int nFrame) throws IOException {
		super(imgX, imgO);
		this.speed = speed;
		this.nFrame = nFrame;
	}

	@Override
	protected void drawImage(Graphics g, ImageIcon img) {

		animator = new Runnable() {
			@Override
			public void run() {
				int frame = 0;
				do {
					drawImage(g, img, frame++, nFrame);
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						break;
					}
				} while (frame <= nFrame);
			}
		};
	}

	protected void drawImage(Graphics g, ImageIcon img, int frame, int totFrame) {
		g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), 0, 0, img.getIconWidth(),
				(img.getIconHeight() / totFrame * (frame + 1)), img.getImageObserver());
	}
}
