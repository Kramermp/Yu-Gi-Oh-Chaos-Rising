package yugioh.chaosrising.duel.ui;

import yugioh.chaosrising.board.ui.SpacePanel;
import yugioh.chaosrising.duel.cntl.DuelCntl;

import javax.swing.*;
import java.awt.*;

public class DuelUI extends JPanel{

	private DuelCntl parentCntl;
	private SpacePanel[][] spacePanelArray;

	public DuelUI(DuelCntl duelCntl) {
		this.parentCntl = duelCntl;
		configurePanel();
		buildSpacePanelArray();
		drawBoard();
	}

	private void configurePanel() {
		setLayout(new GridBagLayout());
	}

	private void buildSpacePanelArray() {
		Dimension boardDimension = parentCntl.getBoardDimensions();
		spacePanelArray = new SpacePanel[boardDimension.height][boardDimension.width];
		for(int i = 0; i < spacePanelArray.length; i++) {
			for(int j =0; j < spacePanelArray[0].length; j++) {
				spacePanelArray[i][j] = new SpacePanel(parentCntl.getSpace(j, i));
			}
		}
	}

	private void drawBoard() {
		GridBagConstraints c = new GridBagConstraints();
		for(int i = 0; i < spacePanelArray.length; i++) {
			for(int j =0; j < spacePanelArray[0].length; j++) {
				c.gridx = j;
				c.gridy = i;
				c.weightx = 1;
				c.weighty = 1;
				c.fill = GridBagConstraints.BOTH;
				add(spacePanelArray[i][j], c);
			}
		}
	}


}
