import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KeyClick extends MouseAdapter {
	private Game _i;
	private String _c;
	private KeyButton _k;

	public KeyClick(Game _i, String _c, KeyButton _k) {
		super();
		this._i = _i;
		this._c = _c;
		this._k = _k;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		_i.playChar(_c);
		_k.removeMouseListener(this);
	}
}