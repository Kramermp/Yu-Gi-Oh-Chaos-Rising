package yugioh.chaosrising.duel.ui;

import yugioh.chaosrising.board.ui.SpacePanel;
import yugioh.chaosrising.duel.cntl.DuelCntl;
import yugioh.chaosrising.player.PlayerEntity;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class DuelUI extends JPanel{

	private DuelCntl parentCntl;
	private SpacePanel[][] spacePanelArray;

	public DuelUI(DuelCntl duelCntl) {
		this.parentCntl = duelCntl;
		configurePanel();
		buildSpacePanelArray();
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

	public void drawPlayerEntities() {
		ArrayList<PlayerEntity> playerEntities = parentCntl.getPlayerEntities();
		for(int i =0; i < playerEntities.size(); i++) {
			PlayerEntity selectedPlayerEntity = playerEntities.get(i);
			Point enitityPosition = selectedPlayerEntity.getPosition();
			System.out.println(selectedPlayerEntity.getPosition().toString());
			spacePanelArray[enitityPosition.y][enitityPosition.x].drawImage(selectedPlayerEntity.getImage());
		}

	}


	public void drawComponents() {
		drawBoard();
		drawPlayerEntities();
		this.revalidate();
	}
}
