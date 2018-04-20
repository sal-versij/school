
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	private Container content;
	private JMenuBar mnuBar = new JMenuBar();
	private JMenu fileMnu = new JMenu("File");
	private JMenuItem newMnuItm = new JMenuItem("New...");
	private JMenuItem openMnuItm = new JMenuItem("Open...");
	private JMenuItem saveMnuItm = new JMenuItem("Save...");
	private JMenuItem saveAsMnuItm = new JMenuItem("Save as...");
	private JMenu helpMnu = new JMenu("?");
	private JMenuItem preferencesMnuItm = new JMenuItem("preferences...");
	private JMenuItem aboutMnuItm = new JMenuItem("about...");
	private JPanel eastPnl = new JPanel();
	private JPanel northPnl = new JPanel();
	private JPanel westPnl = new JPanel();
	private JPanel southPnl = new JPanel();
	private JPanel centerPnl = new JPanel();

	private Dimension size;

	public Window(String title) {
		super(title);

		content = getContentPane();

		content.add(eastPnl, BorderLayout.EAST);
		content.add(northPnl, BorderLayout.NORTH);
		content.add(westPnl, BorderLayout.WEST);
		content.add(southPnl, BorderLayout.SOUTH);

		centerPnl.setLayout(new GridLayout(1, 1));
		content.add(centerPnl, BorderLayout.CENTER);

		fileMnu.add(newMnuItm);
		fileMnu.add(openMnuItm);
		fileMnu.add(saveMnuItm);
		fileMnu.add(saveAsMnuItm);
		mnuBar.add(fileMnu);

		helpMnu.add(preferencesMnuItm);
		helpMnu.addSeparator();
		helpMnu.add(aboutMnuItm);
		mnuBar.add(helpMnu);

		setJMenuBar(mnuBar);
		size = Toolkit.getDefaultToolkit().getScreenSize();
		size.height /= 2;
		size.width /= 2;
		setSize(size);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setCenterGrid(int width, int height) {
		GridLayout a = (GridLayout) (centerPnl.getLayout());
		a.setColumns(width);
		a.setRows(height);
	}

	public void placeCards(ArrayList<Card> cards) {
		centerPnl.removeAll();
		int i = 0;
		for (Iterator iterator = cards.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();
			card.setPosition(i++);
			centerPnl.add(card);
		}
		pack();
	}
}
