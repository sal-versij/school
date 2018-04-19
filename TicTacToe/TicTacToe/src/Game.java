import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game {
	private Window window;
	private boolean player;
	private int[][] board = new int[3][3];
	private boolean automatic;
	private boolean running;

	private static final int N = 0;
	private static final int X = 1;
	private static final int O = 2;

	public Game(Window window) {
		this.window = window;
		automatic = true;
		newGame();
	}

	public void newGame() {
		player = true;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = N;
		running = true;
	}

	public void endGame(boolean player) {
		window.outcomeLbl.setText("Ha vinto " + (player ? "X" : "O"));
		running = false;
		if (automatic)
			newGame();
	}

	public void endGame() {
		window.outcomeLbl.setText("Pareggio");
		running = false;
		if (automatic)
			newGame();
	}

	public void about() {
	}

	public void insert(int x, int y) {
		if (board[x][y] != N)
			return;
		board[x][y] = (player ? X : O);
		window.boardPnls[x][y].set(board[x][y]);
		player = !player;
		check(x, y);
	}

	public void check(int x, int y) {
		int row = 0, col = 0, dia1 = 0, dia2 = 0, draw = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j] == board[x][y]) {
					if (i == x)
						row++;
					if (j == y)
						col++;
					if ((i + j) == (x + y))
						dia1++;
					if ((i - j) == (x - y))
						dia2++;
				} else if (board[i][j] == N) {
					draw++;
				}
		if (row == 3 || col == 3 || dia1 == 3 || dia2 == 3)
			endGame(!player);
		else if (draw == 9)
			endGame();
	}

	public void start() {
		window.newGameMnu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		window.aboutMnu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				about();
			}
		});
		window.automaticMnu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				automatic = !automatic;
			}
		});

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int x = i;
				int y = j;
				window.boardPnls[i][j].addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (running)
							insert(x, y);
					}

					@Override
					public void mouseExited(MouseEvent e) {
					}

					@Override
					public void mouseEntered(MouseEvent e) {
					}

					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
			}
		}
		window.setVisible(true);
	}
}
