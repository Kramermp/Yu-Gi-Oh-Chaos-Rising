/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webcrawler;

import java.util.ArrayList;

/**
 *
 * @author faust_000
 */
public class ConvertToCSVs {
    private static int cardCount = 0;
    
    public static ArrayList<String> process(ArrayList<String> cardNames, 
	    ArrayList<String> cardTypeInfo, ArrayList<ArrayList<String>> cardOtherInfo,
	    ArrayList<String> cardDescription, ArrayList<ArrayList<String>> cardSetData) {
	
	ArrayList<String> cardCSVs = new ArrayList<String>();
	//English, German, French, Spanish, Portueguese, Italian, Japanese, Korean
	
	int namesCount = cardNames.size();
	for(int i = 0; i < namesCount; i++) {
	    final String CV = "%%%";
	    String currentCSV = "";
	    currentCSV = cardCount + CV;
	    if (cardTypeInfo.get(0).toLowerCase().contains("spell")) {
		currentCSV = currentCSV + "Spell" + CV + cardNames.get(i) + CV;
	    } else if (cardTypeInfo.get(0).toLowerCase().contains("trap")) {
		currentCSV = currentCSV + "Trap" + CV + cardNames.get(i) + CV;
	    } else if (cardTypeInfo.get(0).toLowerCase().contains("effect")){
		currentCSV = currentCSV + "Effect_Monster" + CV + cardNames.get(i) + CV;
	    } else {
		currentCSV = currentCSV + "Monster" + CV + cardNames.get(i) + CV;
	    }
	    int typeCount = cardTypeInfo.size();
	    for(int j = 0; j < typeCount; j++) {
		currentCSV = currentCSV + cardTypeInfo.get(j) + CV;
	    }
	    currentCSV = currentCSV + cardDescription.get(i) + CV;
	    int setCount = cardSetData.size();
	    for(int j = 0; j < setCount; j ++) {
		ArrayList<String> selectedSet = cardSetData.get(j);
		int setSize = selectedSet.size();
		for(int k = 0; k < setSize; k++) {
		    currentCSV = currentCSV + selectedSet.get(k) + "$$$";
		}
	    }
	    int otherSize = cardOtherInfo.size();
	    for(int j = 0; j < otherSize; j ++) {
		ArrayList<String> selectedInfo = cardOtherInfo.get(j);
		int setSize = selectedInfo.size();
		for(int k = 0; k < setSize; k++) {
		    currentCSV = currentCSV + selectedInfo.get(k) + "$$$";
		}
	    }
	    cardCSVs.add(currentCSV);
	    //System.out.println(currentCSV);
	}
	

	cardCount++;
	return cardCSVs;
    }
}
