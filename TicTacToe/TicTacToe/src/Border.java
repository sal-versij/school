import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

public class Border implements javax.swing.border.Border {
	private Color c;

	public Border(Color c) {
		this.c = c;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		g.setColor(this.c);
		g.drawRect(x, y, width, height);
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(1, 1, 1, 1);
	}
}
