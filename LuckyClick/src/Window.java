import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame {
	public static int tentativi = 0;

	public Window(String title) {
		super(title);
		addMouseListener(new Mouse(Math.random() * 300, Math.random() * 300, Math.random() * 300, Math.random() * 300));
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void win() {
		JOptionPane.showMessageDialog(null,
				"Hai vinto!!!\n(Wow come hai fatto ad azzeccarlo al " + tentativi + "° colpo?)");
	}

	public static void lose() {
		JOptionPane.showMessageDialog(null, "Riprova sarai più fortunato!!!");
	}
}
