import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Game {
	private Window window;
	private Vector<String> wordDict;
	private String actual = null;
	private char[] gamed = null;
	private int l;
	private int _l;

	public Game(String title, String wordDict) throws IOException {
		window = new Window(this, title);
		this.wordDict = new Vector<String>();
		@SuppressWarnings("resource")
		BufferedReader r = (new BufferedReader(new FileReader(wordDict)));
		String line;
		while ((line = r.readLine()) != null)
			this.wordDict.add(line.toUpperCase());
	}

	public void newGame() {
		actual = wordDict.get((int) (Math.random() * wordDict.size()));
		l = actual.length();
		_l = 0;
		gamed = new char[l];
		System.out.println(actual);
		for (int i = 0; i < actual.length(); i++)
			gamed[i] = '_';
		update();
	}

	public void reset() {
		newGame();
		window.reset();
	}

	public void playChar(String C) {
		if (actual == null)
			return;
		char c = C.charAt(0);
		boolean b = false;
		for (int i = 0; i < actual.length(); i++)
			if (gamed[i] == '_' && actual.charAt(i) == c) {
				gamed[i] = c;
				b = true;
				_l++;
			}
		if (!b)
			window.ominoPanel.error();
		check();
		update();
	}

	private void update() {
		window.label.setText(String.copyValueOf(gamed));
	}

	private void check() {
		if (_l == l)
			win();
		else if (window.ominoPanel.isDead())
			lose();
	}

	private void lose() {
		JOptionPane.showMessageDialog(window, "You lose!!!");
		reset();
	}

	private void win() {
		JOptionPane.showMessageDialog(window, "You win...");
		reset();
	}
}
