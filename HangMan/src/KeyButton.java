import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

	public KeyButton(Game instance, String c) {
		super();
		this.instance = instance;
		setPreferredSize(new Dimension(40, 40));
		this.c = c;
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		l = new JLabel(c);
		l.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				instance.check(c);
			}
		});
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setHorizontalTextPosition(SwingConstants.CENTER);
		l.setText(c);
		springLayout.putConstraint(SpringLayout.NORTH, l, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, l, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, l, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, l, 0, SpringLayout.EAST, this);
		add(l);
	}
}
