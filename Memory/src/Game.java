
import java.io.IOException;
import java.util.ArrayList;

public class Game {
	private int width;
	private int height;
	private Window window;
	private ArrayList<Card> cards;
	private int select;
	private Card first;
	private Card second;
	private int points;

	public Game(String title) {
		window = new Window(title);
	}

	public void newGame(int width, int height) throws IOException {
		this.width = width;
		this.height = height;
		window.setCenterGrid(width, height);
		cards = new ArrayList<Card>();
		for (int i = 0, j = 0; i < (width * height); i += 2, j++) {
			cards.add(new Card(this, j));
			cards.add(new Card(this, j));
		}
		window.placeCards(cards);
		select = 0;
		points = 0;
	}

	public void selectCard(int pos) {
		Card c = cards.get(pos);
		System.out.println(select);
		switch (select++) {
		case 0:
			c.show(true);
			first = c;
			break;
		case 1:
			c.show(true);
			second = c;
			if (first.value == second.value) {
				points++;
				first.lock();
				second.lock();
			}
			reset();
			break;
		case 2:
			reset();
		}
	}

	public void reset() {
		first.show(false);
		second.show(false);
		select = 0;
	}
}
