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
public class ProcessDescriptions {
    public static ArrayList<String> process(ArrayList<String> fileData) {
	ArrayList<String> cardDescriptions = new ArrayList<String>();
	
	boolean gotDescriptions = false;
	
	int lineCount = fileData.size();
	String englishCardDescription = "Description not found.";
	String frenchCardDescription = "Description not found.";
	String germanCardDescription = "Description not found.";
	String italianCardDescription = "Description not found.";
	String portugueseCardDescription = "Description not found.";
	String spanishCardDescription = "Description not found.";
	String japaneseCardDescription = "Description not found.";
	String baseCardDescription = "Description not found.";
	String romajiCardDescription = "Description not found.";
	String chineseCardDescription = "Description not found.";
	String koreanCardDescription = "Description not found.";
	
	for (int i = 0; i < lineCount; i ++) {
	    String selectedLine = fileData.get(i);
	    String sllc = selectedLine.toLowerCase(); //SLLC: Selected Line Lower Case
	    if(!gotDescriptions && sllc.contains("card descriptions")) {
		//This part will parse throught the file for the card Descriptions in varying languages.
		boolean gotEnglishCardDescription = false;
		boolean gotFrenchCardDescription = false;
		boolean gotGermanCardDescription = false;
		boolean gotItalianCardDescription = false;
		boolean gotPortugueseCardDescription = false;
		boolean gotSpanishCardDescription = false;
		boolean gotKanaCardDescription = false;
		boolean gotBaseCardDescription = false;
		boolean gotRomajiCardDescription  = false;
		boolean gotChineseCardDescription = false;
		boolean gotKoreanCardDescription = false;

		while(!gotDescriptions) {
		    if (!gotEnglishCardDescription && sllc.contains("english")) {
			//English is descirption is on next line so we get nextLine;
			i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			englishCardDescription = selectedLine;
			gotEnglishCardDescription = true;
		    }
		    if(!gotFrenchCardDescription && sllc.contains("french")) {
			i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			frenchCardDescription = selectedLine;
			gotFrenchCardDescription = true;
		    }
		    if(!gotGermanCardDescription && sllc.contains("german")) {
			i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			germanCardDescription = selectedLine;
			gotGermanCardDescription = true;
		    }
		    if(!gotItalianCardDescription && sllc.contains("italian")) {
			i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			italianCardDescription = selectedLine;
			gotItalianCardDescription = true;
		    }
		    if(!gotPortugueseCardDescription && sllc.contains("portuguese")) {
			 i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			portugueseCardDescription = selectedLine;
			gotPortugueseCardDescription = true;
		    }
		    if(!gotSpanishCardDescription && sllc.contains("spanish")) {
			 i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			spanishCardDescription = selectedLine;
			gotSpanishCardDescription = true;
		    }
		    if(!gotKanaCardDescription && sllc.contains("japanese")) {
			 i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			japaneseCardDescription = selectedLine;
			gotKanaCardDescription = true;
		    }
		    if(!gotRomajiCardDescription && sllc.contains("romaji")) {
			 i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			romajiCardDescription = selectedLine;
			gotRomajiCardDescription = true;
		    }
		    if(!gotChineseCardDescription && sllc.contains("chinese")) {
			 i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			chineseCardDescription = selectedLine;
			gotChineseCardDescription = true;
		    }
		    if(!gotKoreanCardDescription && sllc.contains("korean")) {
			i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
			koreanCardDescription = selectedLine;
			gotKoreanCardDescription = true;
		    }
		    i++;
		    selectedLine = fileData.get(i);
		    sllc = selectedLine.toLowerCase();
		    //System.out.println(sllc);
		    if(sllc.contains("tcg set") || sllc.contains("ocg set")) {
			//This line marks the end of Card Descirption Section
			gotDescriptions = true;
			System.out.println("TESTSETESTESTSETS");
		    }
		}


	    }
	}
	cardDescriptions.add(englishCardDescription);
	cardDescriptions.add(germanCardDescription);
	cardDescriptions.add(frenchCardDescription);
	cardDescriptions.add(spanishCardDescription);
	cardDescriptions.add(portugueseCardDescription);
	cardDescriptions.add(italianCardDescription);
	cardDescriptions.add(japaneseCardDescription);
	//cardDescriptions.add(baseCardDescription);
	cardDescriptions.add(koreanCardDescription);
	return cardDescriptions;
    }
}
