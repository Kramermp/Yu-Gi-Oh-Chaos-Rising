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
public class ProcessOtherInfo {
    
    public static ArrayList<ArrayList<String>> process(ArrayList<String> fileData) {
	ArrayList<ArrayList<String>> cardOtherInfo = new ArrayList<ArrayList<String>>();
	int lineCount = fileData.size();
	ArrayList<String> support = new ArrayList<String>();
	ArrayList<String> archetype = new ArrayList<String>();
	ArrayList<String> summonCategories = new ArrayList<String>();
	ArrayList<String> banishedCategories = new ArrayList<String>();
	ArrayList<String> miscCategories= new ArrayList<String>();
	ArrayList<String> actions = new ArrayList<String>();

	boolean gotSupport = false;
	boolean gotArchetype = false;
	boolean gotSummons = false;
	boolean gotBanished = false;
	boolean gotMisc = false;
	boolean gotActions = false;
	
	for (int i = 0; i < lineCount; i++) {
	    String selectedLine = fileData.get(i);
	    String sllc = selectedLine.toLowerCase();
	    if(!gotSupport && sllc.contains("support")) {
		while (!sllc.isEmpty()) {
		    i++;
		    selectedLine = fileData.get(i);
		    sllc = selectedLine.toLowerCase();
		    support.add(selectedLine);   
		}
		gotSupport = true;
	    }
	    if (!gotArchetype && sllc.contains("archetype")) {
		while (!sllc.isEmpty()) {
		    i++;
		    selectedLine = fileData.get(i);
		    sllc = selectedLine.toLowerCase();
		    archetype.add(selectedLine);   
		}
		gotArchetype = true;
	    }
	    if (!gotSummons && sllc.contains("summoning")) {
		while (!sllc.isEmpty()) {
		    i++;
		    selectedLine = fileData.get(i);
		    sllc = selectedLine.toLowerCase();
		    summonCategories.add(selectedLine);   
		}
		gotSummons = true;
	    }
	    if (!gotBanished && sllc.contains("banished")) {
		while (!sllc.isEmpty()) {
		    i++;
		    selectedLine = fileData.get(i);
		    sllc = selectedLine.toLowerCase();
		    banishedCategories.add(selectedLine);   
		}
		gotBanished = true;
	    }
	    if (!gotMisc && sllc.contains("miscellaneous")) {
		while (!sllc.isEmpty()) {
		    i++;
		    selectedLine = fileData.get(i);
		    sllc = selectedLine.toLowerCase();
		    miscCategories.add(selectedLine);   
		}
		gotMisc = true;
	    }
	   if (!gotActions && sllc.contains("actions")) {
		while (!sllc.isEmpty()) {
		    i++;
		    selectedLine = fileData.get(i);
		    sllc = selectedLine.toLowerCase();
		    actions.add(selectedLine);   
		}
		gotActions = true;
	    }
	    
	    
	}
	cardOtherInfo.add(support);
	cardOtherInfo.add(archetype);
	cardOtherInfo.add(summonCategories);
	cardOtherInfo.add(banishedCategories);
	cardOtherInfo.add(miscCategories);
	cardOtherInfo.add(actions);
	
	return cardOtherInfo;
    }
    
}
