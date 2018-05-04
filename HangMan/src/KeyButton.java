import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class KeyButton extends JPanel {
	private static final long serialVersionUID = -3557988792795114354L;
	private String c;
	private JLabel l;
	private Game instance;
	private KeyClick ml;
	private boolean enabled = false;

	public KeyButton(Game instance, String c) {
		super();
		this.instance = instance;
		this.c = c;
		this.ml = new KeyClick(this.instance, this.c, this);
		setPreferredSize(new Dimension(40, 40));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		l = new JLabel(c);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setHorizontalTextPosition(SwingConstants.CENTER);
		l.setText(c);
		springLayout.putConstraint(SpringLayout.NORTH, l, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, l, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, l, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, l, 0, SpringLayout.EAST, this);
		add(l);
	}

	public void reset() {
	}

	public void enable() {
		if (!enabled) {
			addMouseListener(ml);
			enabled = true;
		}
	}

	public void disable() {
		if (enabled) {
			removeMouseListener(ml);
			enabled = false;
		}
	}
}
