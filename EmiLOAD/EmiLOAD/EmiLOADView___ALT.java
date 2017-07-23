package EmiLOAD;
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.*;

import org.jsoup.*;
import org.jsoup.Connection.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class EmiLOADView___ALT extends JFrame{
	
	//Globale Variablen initiieren
	private static final long serialVersionUID = 1L;
	
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem options, close;
	
	JPanel panelOben, panelUnten;
	JTextArea area;
	String userID, passwordID;
	JTextField userIDField, passwordIDField;
	JButton submit;
	JScrollPane pane;
	
	String keineAusrede;
	
	//Konstuktor
	public EmiLOADView___ALT() throws IOException{
	super("EMILoader");
	
	menuBar = new JMenuBar();
	menu = new JMenu("Bearbeiten");
	options = new JMenuItem("Optionen");
	close = new JMenuItem("Schließen");
	
	keineAusrede = new String("WICHTIG! ERST LESEN! SONST ISSES WECH! Das sieht hier zugegeben "
			+ "ein bisschen karg aus, aber ich streite "
			+ "mich momentan noch arg mit dem JDialog. Ich habe es allerdings hinbekommen, die "
			+ "Links herauszufiltern und auch separat die Titel herauszufiltern, sodass man die gleich "
			+ "in Labels und zum Parsen verwenden kann. Das Menü hat noch keine Funktion, ich muss "
			+ "diesen Frame ja komplett auf Dialog umbauen. Main vom View getrennt, aber der Controller "
			+ "steckt hier noch drin. Das Ding funktioniert aber soweit, gerne testen. Links dein HAW "
			+ "Username, rechts das Passwort, submit, warten, tadaaa! Geht später oder morgen weiter, "
			+ "meine Augen geben auf, eh!");
	
	area = new JTextArea(5,25);
	area.setLineWrap(true);
	area.setWrapStyleWord(true);
	area.append(keineAusrede);
	
	panelOben = new JPanel();
	panelUnten = new JPanel();
	userIDField = new JTextField(10);
	passwordIDField = new JTextField(10);
	userID = "";
	passwordID = "";
	pane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		 
	submit = new JButton("Submit");
	submit.addActionListener( new ActionListener(){
	    @Override
	    public void actionPerformed(ActionEvent e){
	    	userID = userIDField.getText(); 
			passwordID = passwordIDField.getText();
			
			 area.setText("");
			
			try{
				Connection.Response res = Jsoup.connect(sourceURL)
						 // TODO meinUsername + meinPW ausfuellen:
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
						 area.append(l + "\n");
					 }
					 
					 //Selektiert aus den gefilterten Links nur den jeweiligen Titel
					 Elements titles = kursIDs.select("a[href][title]");
					 for (Element t: titles){
						    System.out.println(t.attr("title"));
						    area.append(t.attr("title") + "\n");
						}					
			}
			catch(IOException e1){
				System.out.println("Fehler");
			}
	    }
	});	
	
		menu.add(options);
		menu.add(close);
		menuBar.add(menu);
		
		panelOben.add(userIDField);
		panelOben.add(passwordIDField);
		panelOben.add(submit);
		panelUnten.add(pane, BorderLayout.CENTER);
		
		add(menuBar, BorderLayout.NORTH);
		add(panelOben, BorderLayout.CENTER);
		add(panelUnten, BorderLayout.SOUTH);
	}
}
