
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JPanel {
	private static final long serialVersionUID = 1L;
	public int value;
	// private Image bgImg;
	private JLabel valueLbl;
	private int position;
	private MouseListener ML;
	private boolean lock = false;

	public Card(Game parent, int value/* , String image */) throws IOException {
		super();
		this.value = value;
		// bgImg = ImageIO.read(new File(image));
		valueLbl = new JLabel(String.valueOf(value));
		add(valueLbl);
		valueLbl.setVisible(false);
		setBorder(BorderFactory.createLineBorder(Color.black));
		ML = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(position);
				parent.selectCard(position);
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		};
		addMouseListener(ML);
	}

	public void show(boolean b) {
		valueLbl.setVisible(b || lock);
	}

	public void setPosition(int i) {
		position = i;
	}

	public void lock() {
		removeMouseListener(ML);
		lock = true;
	}

	// public void paintComponent(Graphics g) {
	// super.paintComponent(g);
	// g.drawImage(bgImg, 0, 0, this);
	// }
}
