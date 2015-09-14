package puzzle_Stones;

import javax.imageio.ImageIO;
import javax.inject.Named;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;

@Named
public class ImageSplit {
	private static final int IMG_WIDTH = 505;
	private static final int IMG_HEIGHT = 300;

	public static void Chunk(int rows, int cols, String imageName) throws IOException {
		System.out.println("tu som dosiel");
		// z kadial taham obrazok
		File file = new File(
				"D:/T-SYSTEMS/PROJEKTY/ProjektGameStudio/4.9.2015Puzzle/jboss-javaee6-webapp/src/main/webapp/resources/images/gamee.jpg");

		try {
			System.out.println("1");
			BufferedImage originalImage = ImageIO.read(file);
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, type);
			ImageIO.write(resizeImageJpg, "jpg", new File(
					"D:/T-SYSTEMS/PROJEKTY/ProjektGameStudio/4.9.2015Puzzle/jboss-javaee6-webapp/src/main/webapp/resources/images/gamee.jpg"));
			System.out.println("Resize Image DONE");
		} catch (Exception e) {

		}

		System.out.println("1");
		FileInputStream fis = new FileInputStream(file);
		System.out.println("2");
		BufferedImage image = ImageIO.read(fis); // nacitanie image adresara
		System.out.println("3");

		int chunks = rows * cols;
		BufferedImage imgs[] = new BufferedImage[chunks]; // Image array to hold// image chunks
															
		int chunkWidth = image.getWidth() / cols; // determines the chunk width// and height
													
		int chunkHeight = image.getHeight() / rows;
		int count = 0;

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				// Initialize the image array with image chunks
				imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

				// draws the image chunk
				Graphics2D gr = imgs[count++].createGraphics();
				gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x,
						chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
				gr.dispose();
			}
		}
		System.out.println("Splitting done");

		// Zapis dielcov obrazku do priecinku
		for (int i = 0; i < imgs.length; i++) {
			if (i < ((imgs.length) - 1)) {
				ImageIO.write(imgs[i], "jpg",
						new File(
								"D:/T-SYSTEMS/PROJEKTY/ProjektGameStudio/4.9.2015Puzzle/jboss-javaee6-webapp/src/main/webapp/resources/images/img"
										+ (i + 1) + ".jpg"));
			} else {
				ImageIO.write(imgs[i], "jpg",
						new File(
								"D:/T-SYSTEMS/PROJEKTY/ProjektGameStudio/4.9.2015Puzzle/jboss-javaee6-webapp/src/main/webapp/resources/images/img"
										+ 0 + ".jpg"));
			}
		}
		System.out.println("Mini images created");
	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();

		return resizedImage;
	}
}