package yugioh.chaosrising.player;

import yugioh.chaosrising.utils.Entity;

import java.awt.*;

public class PlayerEntity extends Entity {

	Point position = new Point();

	public PlayerEntity() {

	}

	public Point getPosition() {
		return this.position;
	}
}
