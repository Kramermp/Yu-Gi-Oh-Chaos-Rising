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
public class ProcessCardSets {
    
    public static ArrayList<ArrayList<String>> process(ArrayList<String> fileData) {
	
	int lineCount = fileData.size() - 1;
	boolean gotDescriptions = false;
	boolean gotTCGSets = false;
	boolean gotOCGSets = false;
	
	ArrayList<ArrayList<String>> cardSetData = new ArrayList<ArrayList<String>>();

	ArrayList<String> englishTCGSetData = new ArrayList<String>();
	ArrayList<String> spanishTCGSetData = new ArrayList<String>();
	ArrayList<String> frenchTCGSetData = new ArrayList<String>();
	ArrayList<String> germanTCGSetData = new ArrayList<String>();
	ArrayList<String> italianTCGSetData = new ArrayList<String>();
	ArrayList<String> portugueseTCGSetData = new ArrayList<String>();
	ArrayList<String> japaneseOCGSetData = new ArrayList<String>();
	ArrayList<String> koreanOCGSetData = new ArrayList<String>();

	for (int i = 0 ; i < lineCount; i++) {
	    String selectedLine = fileData.get(i);
	    String sllc = selectedLine.toLowerCase();
	    //Arraylist of strings? for set data?
	    //Now Parsing for the Card Sets
	    try {
	    if (!gotTCGSets && sllc.contains("tcg set")) {
		//Parseing throught the file for the data on the TCG Sets
		boolean gotEnglishSets = false;
		boolean gotGermanSets = false;
		boolean gotFrenchSets = false;
		boolean gotItalianSets = false;
		boolean gotSpanishSets = false;
		boolean gotPortugueseSets = false;

		while (!gotTCGSets)
		{
		    //System.out.println("test");
		    selectedLine = fileData.get(i);
		    sllc = selectedLine.toLowerCase();
		    if (!gotEnglishSets && sllc.contains("english")) {
			    i = i + 4;
			    //The Set Data comes 4 lines after the language name
			    selectedLine = fileData.get(i);
			    sllc = selectedLine.toLowerCase();
			    while (!selectedLine.equals("")) {
				englishTCGSetData.add(selectedLine);
				//System.out.println(selectedLine);
				i++;
				selectedLine = fileData.get(i);
			    }
			    gotEnglishSets = true;
		    }
//		    if (!gotFrenchSets && sllc.contains("french")) {
//			    i = i + 4;
//			    //The Set Data comes 4 lines after the language name
//			    selectedLine = fileData.get(i);
//			    sllc = selectedLine.toLowerCase();
//			    while (!selectedLine.equals("")) {
//				frenchTCGSetData.add(selectedLine);
//				//System.out.println(selectedLine);
//				i++;
//				selectedLine = fileData.get(i);
//				sllc = selectedLine.toLowerCase();
//			    }
//			    gotFrenchSets = true;
//		    }
//		    if (!gotItalianSets && sllc.contains("italian")) {
//			    i = i + 4;
//			    //The Set Data comes 4 lines after the language name
//			    selectedLine = fileData.get(i);
//			    sllc = selectedLine.toLowerCase();
//			    while (!selectedLine.equals("")) {
//				italianTCGSetData.add(selectedLine);
//				//System.out.println(selectedLine);
//				i++;
//				selectedLine = fileData.get(i);
//				sllc = selectedLine.toLowerCase();
//			    }
//			    gotItalianSets = true;
//		    }
//		    if (!gotGermanSets && sllc.contains("german")) {
//			    i = i + 4;
//			    //The Set Data comes 4 lines after the language name
//			    selectedLine = fileData.get(i);
//			    sllc = selectedLine.toLowerCase();
//			    while (!selectedLine.equals("")) {
//				germanTCGSetData.add(selectedLine);
//				//System.out.println(selectedLine);
//				i++;
//				selectedLine = fileData.get(i);
//				sllc = selectedLine.toLowerCase();
//			    }
//			    gotGermanSets = true;
//		    }
//		    if (!gotSpanishSets && sllc.contains("spanish")) {
//			    i = i + 4;
//			    //The Set Data comes 4 lines after the language name
//			    selectedLine = fileData.get(i);
//			    sllc = selectedLine.toLowerCase();
//			    while (!selectedLine.equals("")) {
//				spanishTCGSetData.add(selectedLine);
//				//System.out.println(selectedLine);
//				i++;
//				selectedLine = fileData.get(i);
//				sllc = selectedLine.toLowerCase();
//			    }
//			    gotSpanishSets = true;
//		    }
//		    if (!gotPortugueseSets && sllc.contains("portuguese")) {
//			    i = i + 4;
//			    //The Set Data comes 4 lines after the language name
//			    selectedLine = fileData.get(i);
//			    sllc = selectedLine.toLowerCase();
//			    while (!selectedLine.equals("")) {
//				portugueseTCGSetData.add(selectedLine);
//				//System.out.println(selectedLine);
//				i++;
//				selectedLine = fileData.get(i);
//				sllc = selectedLine.toLowerCase();
//			    }
//			    gotPortugueseSets = true;
//		    }
		    if(sllc.contains("ocg sets")) {
			gotTCGSets = true;
		    }
		    i++;
		}
	    }
	    }catch (IndexOutOfBoundsException  e) {
		englishTCGSetData = new ArrayList<String>();
		//It didn;t get the proper data any ways
	    }
	    //If we haven't gotten the OCG Sets set and we are at the OCG line
	    //We will now get them
	    try {
	    if(!gotOCGSets && sllc.contains("ocg sets")) {
		boolean gotJapaneseSets = false;
		boolean gotKoreanSets = false;

		while (!gotOCGSets) {
		    //System.out.println(selectedLine);
		    //While we have not gotten the sets

		    
			if (!gotJapaneseSets && sllc.contains("japanese")) {
			    i = i + 4;
			    selectedLine = fileData.get(i);
			    sllc = selectedLine.toLowerCase();
			    //System.out.println(selectedLine);
			    while (!selectedLine.equals("")) {
				japaneseOCGSetData.add(selectedLine);
				i++;
				selectedLine = fileData.get(i);
				sllc = selectedLine.toLowerCase();
				//System.out.println(selectedLine);
			    }
			    gotJapaneseSets = true;
			}
//		    if (!gotKoreanSets && sllc.contains("korean")) {
//			i = i + 4;
//			selectedLine = fileData.get(i);
//			sllc = selectedLine.toLowerCase();
//			//System.out.println(selectedLine);
//			while (!selectedLine.equals("")) {
//			    koreanOCGSetData.add(selectedLine);
//			    i++;
//			    selectedLine = fileData.get(i);
//			    sllc = selectedLine.toLowerCase();
//			    //System.out.println(selectedLine);
//			}
//			gotKoreanSets = true;
//		    }
		    //System.out.println(sllc);
		    if(sllc.contains("card search") || sllc.contains("video game sets")) {
			gotOCGSets = true;
		    }
		    //System.out.println("loop");
		    
			i++;
			selectedLine = fileData.get(i);
			sllc = selectedLine.toLowerCase();
		    
		}
	
	    }
	    } catch (IndexOutOfBoundsException e) {
			japaneseOCGSetData = new ArrayList<String>();
		    //it failed to get the data just ignore it
	    }

	}
	//System.out.println(japaneseOCGSetData.get(0));
	cardSetData.add(englishTCGSetData);
	cardSetData.add(japaneseOCGSetData);
	
	return cardSetData;
    }
}
