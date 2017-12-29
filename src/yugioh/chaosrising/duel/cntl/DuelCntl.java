package yugioh.chaosrising.duel.cntl;

import yugioh.chaosrising.board.Board;
import yugioh.chaosrising.board.Space;
import yugioh.chaosrising.duel.model.Duel;
import yugioh.chaosrising.duel.ui.DuelUI;
import yugioh.chaosrising.player.PlayerEntity;
import yugioh.chaosrising.userinterface.UserInterface;
import yugioh.chaosrising.userinterface.UserInterfaceCntl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DuelCntl {
	private Duel sourceDuel;
	private DuelUI childDisplay;

	private Timer graphicsTimer = new Timer(50, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			childDisplay.drawPlayerEntities();
		}
	});

	public DuelCntl() {
		sourceDuel = new Duel();
		childDisplay = new DuelUI(this);
		UserInterfaceCntl.getInstance().setDisplay(childDisplay);
		childDisplay.drawComponents();
		graphicsTimer.start();
	}

	public Dimension getBoardDimensions() {
		return sourceDuel.getBoard().getDimension();
	}

	public Space getSpace(int xCoordinate, int yCoodinate) {
		return sourceDuel.getBoard().getSpace(xCoordinate, yCoodinate);
	}

	public ArrayList<PlayerEntity> getPlayerEntities() {
		return sourceDuel.getBoard().getPlayerEntities();
	}

}
