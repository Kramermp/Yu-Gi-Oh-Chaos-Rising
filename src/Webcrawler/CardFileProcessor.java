/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webcrawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @author faust_000
 */
public class CardFileProcessor {
    
    public static void main(String[] args) {
    //Open File
    //int i = 48; //Wil be used in the for loop
    //48 Sample Two Effect Type Trap
    //4321 Sample Spell
    //8000 Sample One Effect Type Monster
    String fileName = "";
   //English, German, French, Spanish, Portueguese, Italian, Japanese, Korean
    ArrayList<String> englishCSVs = new ArrayList<String>();
    ArrayList<String> germanCSVs = new ArrayList<String>();
    ArrayList<String> frenchCSVs = new ArrayList<String>();
    ArrayList<String> spanishCSVs = new ArrayList<String>();
    ArrayList<String> portugueseCSVs = new ArrayList<String> ();
    ArrayList<String> italianCSVs = new ArrayList<String> ();
    ArrayList<String> japaneseCSVs = new ArrayList<String>();
    ArrayList<String> koreanCSVs = new ArrayList<String>();

    BufferedReader in = null;
    try {
	for (int i = 0; i < 8090; i ++) {
	    if (i == 2132 ) //This file was removed it was not a card
		i = i + 2;
	    if (i == 2503) //This file was removed
		i++;
	    System.out.println(i);
	    fileName = "CardData/Card " + i + ".txt";
	    //System.out.println("Opening file " + fileName);
	    in = new BufferedReader(new FileReader(fileName));
	    ArrayList<String> fileData = new ArrayList<String>();
	    int j = 0;
	    while(in.ready()) {
		fileData.add(in.readLine());
		//System.out.println(fileData.get(j)); // Prints out the fileData to check for errors	    
		j++;
	    }
	    String englishName = fileData.get(4);
	    stripExcess(fileData);//Prunes the file data into a more manageable arrayList
	    ArrayList<String> cardCSVs = createCSV(fileData, englishName);// Create the actual CSVs that we need
	    //English, German, French, Spanish, Portueguese, Italian, Japanese, Korean
	    englishCSVs.add(cardCSVs.get(0));
	    germanCSVs.add(cardCSVs.get(1));
	    frenchCSVs.add(cardCSVs.get(2));
	    spanishCSVs.add(cardCSVs.get(3));
	    portugueseCSVs.add(cardCSVs.get(4));
	    italianCSVs.add(cardCSVs.get(5));
	    japaneseCSVs.add(cardCSVs.get(6));
	    koreanCSVs.add(cardCSVs.get(7));  
	}
    } catch (FileNotFoundException error) {
	System.out.println("The System could not find the file, " + fileName);
    } catch (IOException error) {
	System.out.println("An IO Exception Occured.");
	System.out.println(error.toString());
    }
    try {
	//English, German, French, Spanish, Portueguese, Italian, Japanese, Korean
	PrintWriter enOut = new PrintWriter(new File("EnglishCSVs.txt"));
//	PrintWriter deOut = new PrintWriter("/Card CSVs/GermanCSVs.txt");
//	PrintWriter frOut = new PrintWriter("/Card CSVs/FrenchCSVs.txt");
//	PrintWriter spOut = new PrintWriter("/Card CSVs/SpanishCSVs.txt");
//	PrintWriter poOut = new PrintWriter("/Card CSVs/PortugueseCSVs.txt");
//	PrintWriter itOut = new PrintWriter("/Card CSVs/ItalianCSVs.txt");
	PrintWriter jpOut = new PrintWriter(new File("JapaneseCSVs.txt"));
//	PrintWriter krOut = new PrintWriter("/Card CSVs/KoreanCSVs.txt");
	int csvCount = englishCSVs.size();
	for(int i = 0 ; i < csvCount; i++) {
	enOut.println(englishCSVs.get(i));
//	    deOut.println(germanCSVs);
//	    frOut.println(frenchCSVs);
//	    spOut.println(spanishCSVs);
//	    poOut.println(portugueseCSVs);
//	    itOut.println(italianCSVs);
	jpOut.println(japaneseCSVs.get(i));
	}
//	    krOut.println(koreanCSVs);
	enOut.flush();
	enOut.close();
	jpOut.flush();
	jpOut.close();
	
    }catch (Exception e) {
	System.out.println("File not found");
    }
    
    
    //Process File to CSV
    //Take CSV to ArrayList
    //Write ArrayList to file
    }
    
    public static ArrayList<String> stripExcess(ArrayList<String> fileData) {
	int lineCount = fileData.size() - 1;
	boolean removedTopBanner = ((fileData.get(0)).toLowerCase()).contains("english");
	boolean removedBottomBanner = fileData.get(lineCount).toLowerCase().contains("retrieved");
//	System.out.println("The System has removed this top banner : " + removedTopBanner);
//	System.out.println("The System has removed this bottom banner : " + removedBottomBanner);
	

	for(int i = 0; i < lineCount; i++) {
	    String selectedLine = fileData.get(i);
	    
	    if(!removedTopBanner) {
		//System.out.println("Checking line " + i); //For testing title is found
		if((selectedLine.toLowerCase()).contains("english")) {
		    //System.out.println("FOUND ENGLISH TITLE ON LINE " + (i + 1)); //Plus one because i is index
		    //This finds the English Title Line Aka the first Line we need
		    for (int j = (i - 1); j > 0; j--) {
			//Subtract one so it does not remove the actual English Line
			//Must remove in reverse order to maintain the indexes
			fileData.remove(j);
			//System.out
		    }
		    removedTopBanner = true;
		    i = 0; //Must reset i back to 0 because it is now back on the first line
		    lineCount = fileData.size() - 1; //Must Now update the Line Count
		}
	    }
	    if (!removedBottomBanner) {
		//System.out.println("Checking line " + i + " for the bottom Banner");
		if (selectedLine.toLowerCase().contains("other card information")) {
		    //System.out.println("FOUND BOTTOM BANNER ON LINE " + (i + 1));
		    for(int j = lineCount; j > i; j--) {
			//System.out.println("Removing line " + (j + 1)); //Testing purposes
			fileData.remove(j);
			lineCount = fileData.size() - 1; //Recalculate lineCount
		    }
		}
	    }
	    if (selectedLine.contains("translation")) {
		//System.out.println("check translation found");
		//System.out.println(selectedLine);
		fileData.remove(i);
		lineCount = fileData.size() - 1;
	    }
	}
//	for(int i = 0; i < lineCount; i++) {
//	    System.out.println(fileData.get(i));
//	}

	return fileData;
    }
    
    public static ArrayList<String> createCSV(ArrayList<String> fileData, 
	    String englishName) {
	int lineCount = fileData.size();
	String englishCardName = englishName;
	String frenchCardName = "Name not found.";
	String germanCardName = "Name not found.";
	String italianCardName = "Name not found.";
	String portugueseCardName = "Name not found.";
	String spanishCardName = "Name not found.";
	String kanaCardName = "Name not found.";
	String baseCardName = "Name not found."; //Base is a japanese language term
	String romajiCardName = "Name not found.";
	String chineseCardName = "Name not found.";
	String koreanCardName = "Name not found.";
	
	String cardType = "Error";
	String cardEffects = "";
	
	
	boolean hasCardType = false;
	int typeIndex = 0;
	for (int i = 0 ; i < lineCount; i++) {
	    String selectedLine = fileData.get(i);
	    if (selectedLine.toLowerCase().contains("french")) {
		frenchCardName = selectedLine;
	    }
	    if (selectedLine.toLowerCase().contains("german")) {
		germanCardName = selectedLine;
	    }
	    if (selectedLine.toLowerCase().contains("italian")) {
		italianCardName = selectedLine;
	    }
	    if (selectedLine.toLowerCase().contains("portuguese")) {
		portugueseCardName = selectedLine;
	    }
	    if(selectedLine.toLowerCase().contains("spanish")) {
		spanishCardName = selectedLine;
	    }
	    if (selectedLine.toLowerCase().contains("japanese (kana)")) {
		kanaCardName = selectedLine;
	    }
	    if(selectedLine.toLowerCase().contains("japanese (rōmaji)")) {
		romajiCardName = selectedLine;
	    }
	    if (selectedLine.toLowerCase().contains("chinese")) {
		chineseCardName = selectedLine;
	    }
	    if (selectedLine.toLowerCase().contains("korean")) {
		koreanCardName = selectedLine;
	    }
	    if (fileData.get(i).toLowerCase().contains("type") ) {
		//System.out.println(fileData.get(i)); //Prints the card type for testing purposes
		hasCardType = true;
		typeIndex = i; //the index of the Type is important because attribute and magic type is based around this index
		cardType = selectedLine;
		//Break  once we have card Type because it will change how the card is processed
		break;
	    }
	}
	
	//We now have the names of Card and its card Type
	ArrayList<String> cardTypeInfo = new ArrayList<String>();
	//System.out.println("Butts");
	if (cardType.toLowerCase().contains("spell ")) {
	    //Process Spell Cards
	    System.out.println("Butts");
	    System.out.println(cardType);
	    cardTypeInfo = ProcessMagicCard.process(fileData, typeIndex, cardType);
	} else if (cardType.toLowerCase().contains("trap")) {
	    //Process Trap Cards
	    cardTypeInfo = ProcessTrapCard.process(fileData, typeIndex, cardType);
	} else {
	    //Process Monster Cards
	    System.out.println("WTF???");
	    cardTypeInfo = ProcessMonsterCard.process(fileData, cardType, typeIndex);
	}
	    //Formatting from this point forward should be univeral despite card
	    //Type
	    
	    /*
	    Returns an Array List of all the descriptions:
	    English, German, French, Spanish, Portueguese, Italian, Japanese, Korean
	    */
	    ArrayList<String> cardDescriptions = ProcessDescriptions.process(fileData);
	    
//	    for(int i = 0; i < cardDescriptions.size(); i++) {
	    //This loop prints all of the descriptions so you can see errors.
//		System.out.println(cardDescriptions.get(i));
//	    }
	    
	    /*
	    This will return an array list of the different card sets:
	    English, German, French, Spanish, Portueguese, Italian, Japanese, Korean
	    */
	    ArrayList<ArrayList<String>> cardSetData = ProcessCardSets.process(fileData);
	    
	    //Prints the arrays for testing purposes
//	    for(int i = 0; i < cardSetData.size(); i++) {
//		//8 is the count of language arrays
//		ArrayList<String> selectedLanguage = cardSetData.get(i);
//		int setCount = selectedLanguage.size();
//		for(int j = 0; j < setCount; j ++) {
//		    String selectedSet = selectedLanguage.get(j);
//		    System.out.println(selectedSet);
//		}
//	    }
	    //System.out.println(cardSetData.get(6).get(0));
	    //System.out.println("here");
	    ArrayList<ArrayList<String>> cardOtherInfo = ProcessOtherInfo.process(fileData);
//	    for (int i = 0; i < cardOtherInfo.size(); i ++) {
//		//System.out.println("here");
//		ArrayList<String> selectedCategory = cardOtherInfo.get(i);
//		for(int j = 0; j < selectedCategory.size(); j++) {
//		    System.out.println(selectedCategory.get(j));
//		}
//	    }
	    ArrayList<String> cardNames = new ArrayList<String>();
	    //English, German, French, Spanish, Portueguese, Italian, Japanese, Korean
		cardNames.add(englishCardName.replace("English	 ", ""));
		cardNames.add(germanCardName.replace("German	 ", ""));
		cardNames.add(frenchCardName.replace("French	 ", ""));
		cardNames.add(spanishCardName.replace("Spanish	 ", ""));
		cardNames.add(portugueseCardName.replace("Portuguese	 ", ""));
		cardNames.add(italianCardName.replace("Italian	 ", ""));
		cardNames.add(kanaCardName.replace("Japanese (kana)	 ", ""));
		cardNames.add(koreanCardName.replace("Korean	 ", ""));
	    //Now have	<ArrayList<ArrayList<String>> cardSetData
	    //		<ArrayList<ArrayList<String>> cardOtherInfo
	    //		<ArrayList<String> cardTypeInfo
	    
	    //		<ArrayList<String> name and stuff
	    return ConvertToCSVs.process(cardNames, cardTypeInfo, cardOtherInfo
		   ,cardDescriptions, cardSetData);
    }
    
    
    
}
