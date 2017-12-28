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
public class ProcessMonsterCard {
    public static ArrayList<String> process(ArrayList<String> fileData,
	    String cardType, int typeIndex) {
	System.out.println("test");
	
	int lineCount = fileData.size();
	ArrayList<String> monsterCardInfo = new ArrayList<String>();
	String cardAttribute;
	String cardLevel;
	String cardAtkNDef;
	String cardPassCode = "";
	String cardStatus = "";
	String cardEffects = "";
	
	boolean gotPassCode = false;
	boolean gotStatus = false;
	boolean isEffectMonster = cardType.toLowerCase().contains("effect");
	boolean gotEffectsType = false;

	cardAttribute = fileData.get(typeIndex - 1);
	cardLevel = fileData.get(typeIndex + 1);
	cardAtkNDef = fileData.get(typeIndex + 2);
	for(int i = typeIndex + 2; i < lineCount; i ++) {
	    String selectedLine = fileData.get(i);
	    String sllc = selectedLine.toLowerCase(); //SLLC: Selected Line Lower Case

	    if(!gotPassCode) {
		if (sllc.contains("passcode")) {
		    gotPassCode = true;
		    cardPassCode = selectedLine;
		}
	    }
	    if (!gotStatus && sllc.contains("status")) {
		gotStatus = true;  
		cardStatus = selectedLine;
	    }
	    if(isEffectMonster && !gotEffectsType) {
		//This will require a loop
		if (sllc.contains("card effect type")) {
		    i = i + 2; //Skip two lines
		    selectedLine = fileData.get(i);
		    sllc = selectedLine.toLowerCase();
		    while (!gotEffectsType){
			//System.out.println("Looped"); //testing purposes
			if(!selectedLine.equals("")) {
			    cardEffects = cardEffects + "^" + selectedLine;
			}
			i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			if(sllc.contains("status")) {
			    gotEffectsType = true;
			}
		    }
		}  
	    }
	   
	}
	monsterCardInfo.add(cardType.replace("Types", ""));
	monsterCardInfo.add(cardAttribute.replace("Attribute", ""));
	monsterCardInfo.add(cardLevel.replace("Level", ""));
	monsterCardInfo.add(cardAtkNDef.replace("ATK / DEF ", ""));
	monsterCardInfo.add(cardPassCode.replace("Passcode ", ""));
	monsterCardInfo.add(cardEffects);
	
	return monsterCardInfo;
    }
    
}
