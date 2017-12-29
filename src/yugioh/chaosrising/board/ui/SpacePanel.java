package yugioh.chaosrising.board.ui;

import yugioh.chaosrising.board.Space;
import yugioh.chaosrising.player.PlayerEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SpacePanel extends JPanel {

	private Space sourceSpace;

	public SpacePanel(Space sourceSpace) {
		this.sourceSpace = sourceSpace;
		drawSpace();
	}

	private void drawSpace() {
		switch(sourceSpace.getSpaceType()) {
			case MEADOW:
				setBackground(Color.GREEN);
				break;
			case WATER:
				setBackground(Color.BLUE);
				break;
			case NORMAL:
				setBackground(Color.GRAY);
				break;
			case DARK:
				setBackground(Color.BLACK);
				break;
			case TOON:
				setBackground(Color.PINK);
				break;
			case CRUSH:
				setBackground(Color.RED);
				break;
			case WASTELAND:
				setBackground(Color.ORANGE);
				break;
			case FOREST:
				setBackground(Color.GREEN);
				break;
			case MOUNTAIN:
				setBackground(Color.DARK_GRAY);
				break;
			case LABYRINTH:
				setBackground(Color.YELLOW);
				break;
		}
	}

	public void drawImage(BufferedImage imageToDraw) {
		System.out.println("Here");
		Graphics g = this.getGraphics();
		g.drawImage(imageToDraw, 0, 0, getWidth(), getHeight(), null);


	}
}
