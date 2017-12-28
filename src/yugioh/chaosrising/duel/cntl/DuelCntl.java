package yugioh.chaosrising.duel.cntl;

import yugioh.chaosrising.duel.ui.DuelUI;
import yugioh.chaosrising.userinterface.UserInterface;
import yugioh.chaosrising.userinterface.UserInterfaceCntl;

public class DuelCntl {

	public DuelCntl() {
		DuelUI childDisplay = new DuelUI(this);
		UserInterfaceCntl.getInstance().setDisplay(childDisplay);
	}

}
