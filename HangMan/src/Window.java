import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	public OminoPanel ominoPanel;
	private JPanel wordPanel;
	private JPanel keyboardPanel;
	private Box keyboardVBox;
	private KeyButton rs[] = new KeyButton[26];
	public JLabel label;
	private static final String[] map = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G",
			"H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M" };
	private JPanel keyboardR1Panel;
	private JPanel keyboardR2Panel;
	private JPanel keyboardR3Panel;
	private Game instance;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu gameMnu = new JMenu("Game");
	private JMenuItem newGameMenuItm = new JMenuItem("New Game...");
	private Container c;

	public Window(Game instance, String title) {
		super(title);
		this.instance = instance;
		final Game _i = instance;

		c = getContentPane();

		SpringLayout springLayout = new SpringLayout();
		c.setLayout(springLayout);

		newGameMenuItm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_i.reset();
			}
		});
		gameMnu.add(newGameMenuItm);
		menuBar.add(gameMnu);
		setJMenuBar(menuBar);

		ominoPanel = new OminoPanel();
		springLayout.putConstraint(SpringLayout.NORTH, ominoPanel, 10, SpringLayout.NORTH, c);
		springLayout.putConstraint(SpringLayout.WEST, ominoPanel, 10, SpringLayout.WEST, c);
		springLayout.putConstraint(SpringLayout.SOUTH, ominoPanel, 110, SpringLayout.NORTH, c);
		springLayout.putConstraint(SpringLayout.EAST, ominoPanel, 110, SpringLayout.WEST, c);
		c.add(ominoPanel);

		wordPanel = new JPanel();
		wordPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		springLayout.putConstraint(SpringLayout.NORTH, wordPanel, 50, SpringLayout.NORTH, ominoPanel);
		springLayout.putConstraint(SpringLayout.WEST, wordPanel, 6, SpringLayout.EAST, ominoPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, wordPanel, 0, SpringLayout.SOUTH, ominoPanel);
		springLayout.putConstraint(SpringLayout.EAST, wordPanel, -10, SpringLayout.EAST, c);
		c.add(wordPanel);

		keyboardPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, keyboardPanel, 6, SpringLayout.SOUTH, ominoPanel);
		springLayout.putConstraint(SpringLayout.WEST, keyboardPanel, 0, SpringLayout.WEST, ominoPanel);
		springLayout.putConstraint(SpringLayout.SOUTH, keyboardPanel, -10, SpringLayout.SOUTH, c);
		springLayout.putConstraint(SpringLayout.EAST, keyboardPanel, 0, SpringLayout.EAST, wordPanel);
		SpringLayout sl_wordPanel = new SpringLayout();
		wordPanel.setLayout(sl_wordPanel);

		label = new JLabel("");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setToolTipText("Parola");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		sl_wordPanel.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, wordPanel);
		sl_wordPanel.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, wordPanel);
		sl_wordPanel.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, wordPanel);
		sl_wordPanel.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, wordPanel);
		wordPanel.add(label);
		c.add(keyboardPanel);

		keyboardVBox = Box.createVerticalBox();
		keyboardPanel.add(keyboardVBox);

		keyboardR1Panel = new JPanel();
		keyboardVBox.add(keyboardR1Panel);

		keyboardR2Panel = new JPanel();
		keyboardVBox.add(keyboardR2Panel);

		keyboardR3Panel = new JPanel();
		keyboardVBox.add(keyboardR3Panel);

		createKeyboard();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 350);
	}

	private void createKeyboard() {
		for (int i = 0; i < 26; i++) {
			rs[i] = new KeyButton(instance, map[i]);
			rs[i].enable();
			if (i < 10)
				keyboardR1Panel.add(rs[i]);
			else if (i < 19)
				keyboardR2Panel.add(rs[i]);
			else
				keyboardR3Panel.add(rs[i]);
		}
	}

	public void reset() {
		ominoPanel.reset();
		for (int i = 0; i < rs.length; i++) {
			rs[i].enable();
		}
	}
}
