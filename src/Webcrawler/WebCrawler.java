/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webcrawler;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;




/**
 *
 * @author faust_000
 */
public class WebCrawler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
	String basePage = "http://yugioh.wikia.com";
	String startingPlace = "/wiki/Category:OCG_cards?";
	ArrayList<String> linkList = new ArrayList<String>();
	
	 WebClient webClient = new WebClient();
	    webClient.getOptions().setCssEnabled(false);//if you don't need css
	    webClient.getOptions().setJavaScriptEnabled(false);//if you don't need js
	HtmlPage page = null;
	
	try {
	    String webPageURL = basePage + startingPlace;
	    for (int i = 0; i < 41; i++) {
		//Get Page
		page = webClient.getPage(webPageURL);
		//Trim Page
		String TrimmedPage = trimPage(page.asXml());
		//Scan trimmed Page
		ArrayList<String> links = scanPage(TrimmedPage);
		//Proccess Links
		linkList.addAll(processLinks(links));
		//System.out.println(linkList.size());
		webPageURL = basePage + linkList.get(linkList.size() - 1);
		//System.out.println(webPageURL);	
	    }
	    
	    //Find the Index of non Card Links
	    int linkCount = linkList.size() - 1;
	    ArrayList<Integer> badIndex = new ArrayList<Integer>();
	    for(int i = 0; i < linkCount; i++) {
		//System.out.println(linkList.get(i));
		if (linkList.get(i).contains("Category")){
		    badIndex.add(i);
		    //System.out.println(i);
		}
	    }
	    //Remove non Card links in reverse order as to no shift indexes
	    int badIndexCount = badIndex.size() - 1;
	    //System.out.println(badIndexCount);
	    for(int i = badIndexCount; i >= 0; i--) {
		int index = badIndex.get(i);
		linkList.remove(index);
		//System.out.println("Removing index " + index);
	    }
	    linkCount = linkList.size() - 1;
	    
	    //output the Urls to url file
	    PrintWriter out =  new PrintWriter("URLs.txt");
	    for(int i = 0; i < linkCount; i++) {
		out.println(linkList.get(i));
	    }
	    out.flush();
	    out.close();
	    //System.out.println(linkCount);
	    //Still 70? to many;
	    
	    //Begin going to each card URL and pulling the data
	    for (int i = 0; i < linkCount; i ++) {
		page = webClient.getPage(basePage + linkList.get(i));
		//System.out.println(page.getTitleText());
		//Page is now loaded now to get the card info
		String pageData = page.asText();
		Scanner scnr = new Scanner (pageData);
		scnr.useDelimiter("Watchlist Page Recent changes");
		scnr.next();
		pageData = scnr.next();
		System.out.println(pageData);
		String fileName = "CardData/card "  + i  + ".txt";
		//We write the strng to file
		PrintWriter out2 = new PrintWriter(fileName);
		Scanner test = new Scanner (pageData);
		out2.print(pageData);
		out2.flush();
		out2.close();
	    }
	    //We now have approx 8000 card files on the harddive so we can stop
	    //DDoS 
	    
	} catch (IOException e) {
	    System.out.println(e.toString());
	}

    }
    
    public static String trimPage(String pageData) {

	Scanner trimmer = new Scanner(pageData);
	//Cuts of the top portion of the page
	    trimmer.useDelimiter("<div id=\"mw-pages\">");
	    trimmer.next();
	    //Cuts the bottom Portion of the page
	    trimmer.useDelimiter("<a href=\"/wiki/Special:Categories\"");
	    return trimmer.next(); //Returns the properly trimmed webpage
    }
    public static ArrayList<String> scanPage(String pageData) {
	    Scanner scnr = new Scanner(pageData);
	    ArrayList<String> linksOnPage = new ArrayList<String>();
	    while (scnr.hasNext()) {
		String selectedLine = scnr.nextLine();
		if (selectedLine.contains("<a") && !selectedLine.contains("http")) {
		    linksOnPage.add(selectedLine);
		    //System.out.println(selectedLine);
		}
	    }
	return linksOnPage;
    }
    
    public static ArrayList<String> processLinks(ArrayList<String> links) {
	ArrayList<String> properLinks = new ArrayList<String>();
	for (int i = 0; i < links.size(); i ++) {
	    Scanner scnr = new Scanner(links.get(i));
	    scnr.useDelimiter("/wiki/");
	    scnr.next();
	    scnr.useDelimiter("\" title=");
	    String link = scnr.next();
	    //System.out.println(link);
	    properLinks.add(link);
	}
	return properLinks;
    }
}
