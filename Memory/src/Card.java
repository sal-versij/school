
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
	private Game parent;
	private int position;
	private MouseListener ML;

	public Card(Game parent, int value/* , String image */) throws IOException {
		super();
		this.parent = parent;
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
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(position);
				parent.selectCard(position);
			}
		};
		addMouseListener(ML);
	}

	public void show(boolean b) {
		valueLbl.setVisible(b);
	}

	public void setPosition(int i) {
		position = i;
	}

	public void lock() {
		removeMouseListener(ML);
	}

	// public void paintComponent(Graphics g) {
	// super.paintComponent(g);
	// g.drawImage(bgImg, 0, 0, this);
	// }
}
