import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
	double x;
	double y;
	double w;
	double h;

	public Mouse(double x, double y, double w, double h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		System.out.println(x + "-" + y + "-" + w + "-" + h);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int dx = (int) (e.getX() - x);
		int dy = (int) (e.getY() - y);
		Window.tentativi++;
		if (dx >= 0 && dx <= w && dy >= 0 && dy <= h) {
			Window.win();
		} else {
			Window.lose();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
