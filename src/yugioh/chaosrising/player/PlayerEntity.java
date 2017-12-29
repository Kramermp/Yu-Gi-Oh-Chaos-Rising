package yugioh.chaosrising.player;

import yugioh.chaosrising.utils.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PlayerEntity extends Entity {

	Point position;

	public PlayerEntity() {
		position = new Point(0, 0);
	}

	public Point getPosition() {
		return this.position;
	}

	public BufferedImage getImage()  {

		BufferedImage test = null;
		try {
			test = ImageIO.read(new File("resources/TempPlayerIcon.png"));
		} catch (FileNotFoundException ex) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(test == null) {
			System.out.println(":setdsfsadf");
		}
		return test;
	}
}
