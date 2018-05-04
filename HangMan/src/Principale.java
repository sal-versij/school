import java.io.IOException;

public class Principale {
	public static void main(String[] args) throws IOException {
		Game g = new Game("Prova", "words.txt");
		g.newGame();
	}
}
