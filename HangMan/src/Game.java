import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Game {
	private Window window;
	private Vector<String> wordDict;
	private String actual = null;
	private char[] gamed = null;

	public Game(String title, String wordDict) throws IOException {
		window = new Window(this, title);
		this.wordDict = new Vector<String>();
		BufferedReader r = (new BufferedReader(new FileReader(wordDict)));
		String line;
		while ((line = r.readLine()) != null)
			this.wordDict.add(line.toUpperCase());
	}

	public void newGame() {
		actual = wordDict.get((int) (Math.random() * wordDict.size()));
		gamed = new char[wordDict.size()];
		System.out.println(actual);
		System.out.println(gamed);
		for (int i = 0; i < actual.length(); i++) {
			gamed[i] = '_';
		}
	}

	public void reset() {
		newGame();
	}

	public boolean playChar(String C) {
		if (actual == null)
			return false;
		System.out.println(C);
		char c = C.charAt(0);
		boolean b = false;
		for (int i = 0; i < actual.length(); i++)
			if (gamed[i] == '_' && actual.charAt(i) == c) {
				gamed[i] = c;
				b = true;
			}
		System.out.println(gamed);
		return b;
	}
}
