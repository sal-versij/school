import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Utils {

	public static ImageIcon loadImage(String path) throws IOException {
		return new ImageIcon(path);
	}

}
