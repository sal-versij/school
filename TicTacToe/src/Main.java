import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Game G = new Game(new Window("TicTacToe"));
		G.start();
	}
}
