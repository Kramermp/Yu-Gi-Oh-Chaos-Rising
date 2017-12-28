package yugioh.chaosrising.userinterface;

import yugioh.chaosrising.duel.cntl.DuelCntl;

import javax.swing.*;
import java.awt.*;

public class UserInterfaceCntl {
	private UserInterface userInterface = new UserInterface();


	public void setDisplay(Component componentToDisplay) {
		userInterface.removeAll();
		userInterface.add(componentToDisplay);
		userInterface.revalidate();
	}

	private UserInterfaceCntl() {
		configureUserInterface();
	}

	private void configureUserInterface() {
		userInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userInterface.setExtendedState(JFrame.MAXIMIZED_BOTH);
		userInterface.setVisible(true);
	}

	public void loadDuel(){
		new DuelCntl();
	}

	public static final UserInterfaceCntl getInstance() {
		return LazyHolder.INSTANCE;
	}

	private static class LazyHolder {
		static UserInterfaceCntl INSTANCE = new UserInterfaceCntl();

	}
}
