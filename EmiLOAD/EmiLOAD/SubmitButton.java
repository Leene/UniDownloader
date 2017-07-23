package EmiLOAD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SubmitButton extends EMILoadVIEW implements ActionListener{

		@Override
        public void actionPerformed(ActionEvent submitKlicked){
    		userID = userIDField.getText(); 
    		passwordID = passwordIDField.getText();
    		
    		try{
    			Connection.Response res = Jsoup.connect(sourceURL)
    					// TODO für "username" den Input des userID String
    					// TODO für "password" den Input des passwordID String
    					.data("username", userID, "password", passwordID)
    					.method(Method.POST).execute();
    			
    			Document doc = res.parse();
    			String sessionId = res.cookie("MoodleSession");
    			
    			Document doc2 = Jsoup.connect("https://www.elearning.haw-hamburg.de/my/")
    					.cookie("MoodleSession", sessionId)
    					.get();
    			
    			//Parsed den gesamten html Inhalt der class:"course_title"
    				Elements kursIDs = doc2.getElementsByClass("course_title");
    				
    			//Filtert aus dem geparsden html Code alle a[href] tags
    				Elements links = kursIDs.select("a[href]");
    				
    			//Selektiert aus den gefilterten Links nur den jeweiligen Titel
    				Elements titles = kursIDs.select("a[href][title]");
    					for (Element t: titles){
    						System.out.println(t.attr("title"));
    					}
    			
    			//Selektiert aus den gefilterten Links nur die URL http://(...).id=xyz
    				for(Element link: links){
    					String l = link.attr("href");
    					if(l.length()>0){
    						if(l.length()<4)
    							l = doc.baseUri()+l.substring(1);
    						else if(!l.substring(0, 4).equals("http"))
    							l = doc.baseUri()+l.substring(1);
    						}
    					System.out.println(l);
    				}
    		}				
    		catch(IOException submitKlicked1){
    			System.out.println("Fehler");
    		}
        };
}