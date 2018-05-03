
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel ominoPanel;
	private JPanel wordPanel;
	private JPanel keyboardPanel;
	private Box keyboardVBox;
	private KeyButton rs[] = new KeyButton[26];
	private JLabel label;
	private static final String[] map = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G",
			"H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M" };
	private JPanel keyboardR1Panel;
	private JPanel keyboardR2Panel;
	private JPanel keyboardR3Panel;
	private Game instance;

	public Window(Game instance, String title) {
		super(title);
		this.instance = instance;
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		ominoPanel = new JPanel();
		ominoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		springLayout.putConstraint(SpringLayout.NORTH, ominoPanel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, ominoPanel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, ominoPanel, 110, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, ominoPanel, 110, SpringLayout.WEST, getContentPane());
		ominoPanel.setSize(100, 100);
		getContentPane().add(ominoPanel);

		wordPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, wordPanel, 50, SpringLayout.NORTH, ominoPanel);
		wordPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		springLayout.putConstraint(SpringLayout.WEST, wordPanel, 6, SpringLayout.EAST, ominoPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, wordPanel, 0, SpringLayout.SOUTH, ominoPanel);
		springLayout.putConstraint(SpringLayout.EAST, wordPanel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(wordPanel);

		keyboardPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, keyboardPanel, 6, SpringLayout.SOUTH, ominoPanel);
		springLayout.putConstraint(SpringLayout.WEST, keyboardPanel, 0, SpringLayout.WEST, ominoPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, keyboardPanel, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, keyboardPanel, 0, SpringLayout.EAST, wordPanel);
		SpringLayout sl_wordPanel = new SpringLayout();
		wordPanel.setLayout(sl_wordPanel);

		label = new JLabel("");
		sl_wordPanel.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, wordPanel);
		sl_wordPanel.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, wordPanel);
		sl_wordPanel.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, wordPanel);
		sl_wordPanel.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, wordPanel);
		wordPanel.add(label);
		getContentPane().add(keyboardPanel);
		keyboardPanel.setLayout(new CardLayout(0, 0));

		keyboardVBox = Box.createVerticalBox();
		keyboardPanel.add(keyboardVBox);

		keyboardR1Panel = new JPanel();
		keyboardVBox.add(keyboardR1Panel);

		keyboardR2Panel = new JPanel();
		keyboardVBox.add(keyboardR2Panel);

		keyboardR3Panel = new JPanel();
		keyboardVBox.add(keyboardR3Panel);

		createKeyboard();

		pack();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 300);
	}

	private void createKeyboard() {
		for (int i = 0; i < 26; i++) {
			rs[i] = new KeyButton(instance, map[i]);
			if (i < 10)
				keyboardR1Panel.add(rs[i]);
			else if (i < 19)
				keyboardR2Panel.add(rs[i]);
			else
				keyboardR3Panel.add(rs[i]);
		}
	}
}
