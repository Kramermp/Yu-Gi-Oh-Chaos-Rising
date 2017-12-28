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
public class ProcessTrapCard {
    public static ArrayList<String> process(ArrayList<String> fileData, int typeIndex,
	    String cardType) {
	ArrayList<String> trapCardData = new ArrayList<String>();
	
	String trapProperty = fileData.get(typeIndex + 1); //Trap property comes 1 after the typeIndex
	String cardEffects = "";
	String passCode = "";
	String status = "";
	int lineCount = fileData.size();
	boolean gotPassCode = false;
	boolean gotEffects = false;
	boolean gotStatus = false;
	
	for(int i = typeIndex + 1; i < lineCount; i++) {
	    String selectedLine = fileData.get(i);
	    String sllc = selectedLine.toLowerCase();
	    if (!gotPassCode && sllc.contains("passcode")) {
		passCode = selectedLine;
	    }
	 
	    if (sllc.contains("card effect type") && ! gotEffects) {
		i = i + 2; //Need to skip to lines
		selectedLine = fileData.get(i);
		sllc = selectedLine.toLowerCase();
		while (!gotEffects){
		    //System.out.println("Looped"); //testing purposes\
		    if(!selectedLine.equals("")) {
			cardEffects = cardEffects + "^" + selectedLine;
			i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			if(sllc.contains("status")) {
			    gotEffects = true;
			}
		    }
		}
	    }  
	    if (sllc.contains("status") && !gotStatus) {
		status = selectedLine;
	    }
	}
	trapCardData.add(cardType);
	trapCardData.add(trapProperty);
	trapCardData.add(cardEffects);
	trapCardData.add(passCode.replace("Passcode   ", ""));
	
	return trapCardData;
    }
    
}
