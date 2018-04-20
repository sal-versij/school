import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game {
	private Window window;
	private boolean player;
	private int[][] board = new int[Constants.H][Constants.W];
	private boolean automatic;
	private boolean running;

	public Game(Window window) {
		this.window = window;
		automatic = true;
		window.outcomeLbl.setText("New game");
		newGame();
	}

	public void newGame() {
		player = true;
		for (int i = 0; i < Constants.H; i++)
			for (int j = 0; j < Constants.W; j++) {
				board[i][j] = Constants.N;
				window.boardPnls[i][j].set(Constants.N);
			}
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

	public void insert(int y) {
		if (board[0][y] != Constants.N)
			return;
		board[0][y] = (player ? Constants.X : Constants.O);
		int x = 0;
		try {
			x = elaborate(y);
		} catch (InterruptedException e) {
			endGame();
			return;
		}
		if (check(x, y))
			player = !player;
	}

	public int elaborate(int y) throws InterruptedException {
		int x;
		for (x = 1; x < Constants.H; x++) {
			if (board[x][y] == Constants.N) {
				board[x][y] = board[x - 1][y];
				board[x - 1][y] = Constants.N;
				window.boardPnls[x - 1][y].set(board[x][y] * 2 + 1);
				window.boardPnls[x][y].set(board[x][y] * 2);
				Thread.sleep(Constants.tick * (Constants.nFrame + 1));
			} else
				break;
		}
		return x - 1;
	}

	public boolean check(int x, int y) {
		int row = 0, col = 0, diag1 = 0, diag2 = 0;
		int i, j;
		for (i = Math.max(0, y - 3); i < Math.min(Constants.W, y + 3); i++) {
			if (board[x][y] == board[x][i])
				row++;
			else
				row = 0;
			if (row == 4)
				break;
		}
		for (i = Math.max(0, x - 3); i < Math.min(Constants.H, x + 3); i++) {
			if (board[x][y] == board[i][y])
				col++;
			else
				col = 0;
			if (col == 4)
				break;
		}
		for (i = Math.max(0, x - 3); i < Math.min(Constants.H, x + 3); i++) {
			for (j = Math.max(0, x - 3); j < Math.min(Constants.H, x + 3); j++) {
				if ((i - j) != (x - y))
					continue;
				if (board[x][y] == board[i][j])
					diag1++;
				else
					diag1 = 0;
				if (diag1 == 4)
					break;
			}
		}
		for (i = Math.max(0, x - 3); i < Math.min(Constants.H, x + 3); i++) {
			for (j = Math.max(0, x - 3); j < Math.min(Constants.H, x + 3); j++) {
				if ((i + j) != (x + y))
					continue;
				if (board[x][y] == board[i][j])
					diag2++;
				else
					diag2 = 0;
				if (diag2 == 4)
					break;
			}
		}
		if (row == 4 || col == 4 || diag1 == 4 || diag2 == 4)
			return true;
		else
			return false;
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

		for (int i = 0; i < Constants.H; i++) {
			for (int j = 0; j < Constants.W; j++) {
				int y = j;
				window.boardPnls[i][j].addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}

					@Override
					public void mousePressed(MouseEvent e) {
						if (running)
							insert(y);
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
