import java.io.IOException;

public class Principale {
	public static void main(String[] args) throws IOException {
		Game g = new Game("HangMan", "words.txt");
		g.newGame();
	}
}
