import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends JFrame {

	private JMenuBar mb = new JMenuBar();
	private JMenu fileMnu = new JMenu("File");
	private JMenu helpMnu = new JMenu("?");
	public JMenuItem newGameMnu = new JMenuItem("New game");
	public JMenuItem aboutMnu = new JMenuItem("About...");
	private JMenu optionsMnu = new JMenu("Options");
	public JMenuItem automaticMnu = new JMenuItem("Automatic");
	private JPanel mainPnl = new JPanel();
	public boardPanel[][] boardPnls = new boardPanel[3][3];
	private JPanel statPnl = new JPanel();
	public JLabel outcomeLbl = new JLabel();
	private Container container;

	public Window(String title) throws IOException {
		super(title);
		container = getContentPane();

		optionsMnu.add(automaticMnu);
		fileMnu.add(optionsMnu);
		fileMnu.add(newGameMnu);
		mb.add(fileMnu);
		helpMnu.add(aboutMnu);
		mb.add(helpMnu);
		setJMenuBar(mb);

		mainPnl.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boardPnls[i][j] = new boardPanel("assets/X.jpg", "assets/O.jpg");
				boardPnls[i][j].setBorder(new Border(new Color(0, 0, 0)));
				mainPnl.add(boardPnls[i][j]);
			}
		}
		container.add(mainPnl, BorderLayout.CENTER);

		statPnl.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		statPnl.setBorder(new Border(new Color(52, 52, 52)));

		statPnl.add(outcomeLbl);
		container.add(statPnl, BorderLayout.SOUTH);

		pack();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 200, 250);
	}

	public void setOutcome(String str) {
		outcomeLbl.setText(str);
	}
}
