package yugioh.chaosrising.player;

import yugioh.chaosrising.utils.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerEntity extends Entity {

	Point position = new Point();

	public PlayerEntity() {

	}

	public Point getPosition() {
		return this.position;
	}

	public BufferedImage getImage() throws IOException {
		return ImageIO.read(new File("resources/TempPlayerIcon.png"));
	}
}
