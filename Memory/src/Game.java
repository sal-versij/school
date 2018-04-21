
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
	private Window window;
	private ArrayList<Card> cards;
	private int select;
	private Card first;
	private Card second;

	public Game(String title) {
		window = new Window(title);
	}

	public void newGame(int width, int height) throws IOException {
		window.setCenterGrid(width, height);
		cards = new ArrayList<Card>();
		for (int i = 0, j = 0; i < (width * height); i += 2, j++) {
			cards.add(new Card(this, j));
			cards.add(new Card(this, j));
		}
		Collections.shuffle(cards);
		window.placeCards(cards);
		select = 0;
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
			if (c == first) {
				select--;
				break;
			}
			c.show(true);
			second = c;
			if (first.value == second.value) {
				first.lock();
				second.lock();
			}
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
