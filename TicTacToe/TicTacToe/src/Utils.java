import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

public class Utils {
	public static Image loadImage(String path) throws IOException {
		return Toolkit.getDefaultToolkit().createImage("background.jpg");
	}
}
