package yugioh.chaosrising.duel.cntl;

import yugioh.chaosrising.board.Board;
import yugioh.chaosrising.board.Space;
import yugioh.chaosrising.duel.model.Duel;
import yugioh.chaosrising.duel.ui.DuelUI;
import yugioh.chaosrising.userinterface.UserInterface;
import yugioh.chaosrising.userinterface.UserInterfaceCntl;

import java.awt.*;

public class DuelCntl {
	private Duel sourceDuel;

	public DuelCntl() {
		sourceDuel = new Duel();
		DuelUI childDisplay = new DuelUI(this);
		UserInterfaceCntl.getInstance().setDisplay(childDisplay);
	}

	public Dimension getBoardDimensions() {
		return sourceDuel.getBoard().getDimension();
	}

	public Space getSpace(int xCoordinate, int yCoodinate) {
		return sourceDuel.getBoard().getSpace(xCoordinate, yCoodinate);
	}
}
