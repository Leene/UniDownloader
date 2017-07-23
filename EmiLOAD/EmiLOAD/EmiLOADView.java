package EmiLOAD;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EMILoadVIEW extends JFrame{
	
	String userID, passwordID, sourceURL, saveDirPath;
	JTextField saveDirField, sourceURLField, userIDField;
	JPasswordField passwordIDField;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem options, close;
	JPanel dialogPanel, sourceLoginPanel, loginPanel, unlockedCoursesPanel, saveDir, dialogResult;
	JScrollPane ucp;
	JLabel userIDLabel, passwordIDLabel, unlockedCourses;
	JButton submit, open, saveDialog, cancelDialog;
	JDialog optionDialog;
	
	//############################################################//
	
	@SuppressWarnings("static-access")
	public EMILoadVIEW(){
		super("EMILoad");
		
		//Die URL festlegen, die geparsed werden und als Hauptnavigation werden soll
		//Als Variable, damit sie im Falle einer Veränderung schnell angepasst werden kann
		sourceURL = "https://www.elearning.haw-hamburg.de/login/index.php";
		
		//Menubar erstellen, mit Menu "Bearbeiten" und dessen MenuItems "Optionen" und "Schließen" füllen
		menubar = new JMenuBar();
		menu = new JMenu("Bearbeiten");
		options = new JMenuItem("Optionen");
		close = new JMenuItem("Schließen");
		
		menubar.add(menu);
			menu.add(options);
			menu.add(close);
		
		//Dialog mit dem Klick auf "Optionen" aufrufen
		//Größe, Layout und Schließfunktion festlegen (in den Hintergrund)
		
		optionDialog = new JDialog();
		optionDialog.setSize(600,600);
		optionDialog.setLayout(new FlowLayout());
		optionDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Dialog mit einem Panel versehen, dass alle anderen Komponenten beinhaltet
		dialogPanel = new JPanel();
		
		//Erstes Panel: SourceURL und Login mit Submit Button
			sourceLoginPanel = new JPanel();
				sourceURLField = new JTextField(sourceURL);
					loginPanel = new JPanel();
						userIDLabel = new JLabel("Benutzername");
						userIDField = new JTextField(10);
						passwordIDLabel = new JLabel("Passwort");
						passwordIDField = new JPasswordField(10);
					submit = new JButton("submit");
					
		//Angemeldeten Kurse in ScrollPane, Checkboxen zum auswählen der Kurse		
			unlockedCoursesPanel = new JPanel();
				ucp = new JScrollPane(unlockedCoursesPanel);
					unlockedCourses = new JLabel("Angemeldete Kurse von " + userID);
			
		//FileChooser mit Klick auf "searchBtn", um den Speicherort der Downloads zu bestimmen
			saveDir = new JPanel();
				saveDirField = new JTextField(10);
				open = new JButton("Öffnen");
				
		//Änderungen, die über den Dialog vorgenommen wurden, übernehmen oder abbrechen
			dialogResult = new JPanel();
				saveDialog = new JButton("Übernehmen");
				cancelDialog = new JButton("Abbrechen");
				
		//#################################################################################				
		
		//Layout für Hauptpanel im Dialog festlegen, BoxLayout von oben nach unten		
		dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.PAGE_AXIS));
		
		//Das erste Panel im Dialog, BoyLayout (v.o.n.u.), loginPanel mit GridLayout integriert
		sourceLoginPanel.setLayout(new BoxLayout(sourceLoginPanel, BoxLayout.PAGE_AXIS));
			loginPanel.setLayout(new GridLayout(2,2));
		
		//Scrollbalken an der Seite und preferierte Größe des Panels für Scrollpane festlegen
		ucp.setVerticalScrollBarPolicy(ucp.VERTICAL_SCROLLBAR_ALWAYS);
		ucp.setPreferredSize(new Dimension(200,100));
		unlockedCoursesPanel.setLayout(new BoxLayout(unlockedCoursesPanel, BoxLayout.Y_AXIS));
		ucp.setVisible(true);
		
		//Layout vom Filechooser Panel
		saveDir.setLayout(new FlowLayout());
		
		//Layout vom letzten Panel zur Übernahme der Angaben
		dialogResult.setLayout(new FlowLayout());
		
	//#######################################################
				
		//ActionListener für den submit Button des Logins
		submit.addActionListener(new ActionListener(){
		
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
					
//////////////////////////////////////////////////////////////////////////////
					ArrayList<String> arrayListCourse = new ArrayList<String>();
					for (Element title : titles) {
						// System.out.println(t.attr("title"));
						String t = title.attr("title") + ";";
						String[] course = t.split(";");

						for (int i = 0; i < course.length; i++) {
							System.out.println(course[i] + "what");

							arrayListCourse.add(course[i]);
							System.out.println("arrayListCourse: "+ arrayListCourse.get(i) + "Anzahl: " + arrayListCourse.size());
						}
						
					}
					
					System.out.println(" fertige arrayListCourse: "+ arrayListCourse + "Anzahl: " + arrayListCourse.size());
					System.out.println("4. Element: "+ arrayListCourse.get(3));
					
/////////////////////////////////////////////////////////////////////////////////
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
		}});
		
		//ActionListener für den FileChooser
		open.addActionListener(new ActionListener(){
			    
	    public void actionPerformed(ActionEvent e){	
	    	JFileChooser saveDirChooser = new JFileChooser(); 
	    	saveDirChooser.setCurrentDirectory(new java.io.File("."));
	    	saveDirChooser.setDialogTitle(saveDirPath);
	    	saveDirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    	//
	    	// disable the "All files" option.
	    	//
	    	saveDirChooser.setAcceptAllFileFilterUsed(false);
	    	//    
	    	if (saveDirChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) { 
	    		System.out.println("getCurrentDirectory(): " 
	    				+  saveDirChooser.getCurrentDirectory());
	    		System.out.println("getSelectedFile() : " 
	    				+  saveDirChooser.getSelectedFile());
	    		saveDirField.setText(saveDirChooser.getSelectedFile().getPath());
	    	}
	    	else {
	    		System.out.println("No Selection ");
	    	}
	    }});
			
		options.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				optionDialog.setVisible(true);		    	
		    }});
		
		//Nur zum Testen, hier wird später der Name verwendet
		
		JPanel idPanel = new JPanel();
		JLabel courseLabel = new JLabel("Angemeldete Kurse zum Synchronisieren von " + userIDField.getText());
		
		JPanel coursePanel = new JPanel();
		coursePanel.setPreferredSize(new Dimension(400,400));
				
		coursePanel.setBackground(Color.DARK_GRAY);
		idPanel.add(courseLabel);
		coursePanel.add(idPanel, BorderLayout.NORTH);
		
		add(menubar, BorderLayout.NORTH);
		add(coursePanel, BorderLayout.CENTER);
		
		loginPanel.add(userIDLabel);
		loginPanel.add(passwordIDLabel);
		loginPanel.add(userIDField);
		loginPanel.add(passwordIDField);
		
		sourceLoginPanel.add(Box.createVerticalStrut(20));	
		sourceLoginPanel.add(sourceURLField);
		sourceLoginPanel.add(Box.createVerticalStrut(20));				
		sourceLoginPanel.add(loginPanel);
		sourceLoginPanel.add(Box.createVerticalStrut(20));
		sourceLoginPanel.add(submit);
		sourceLoginPanel.add(Box.createVerticalStrut(20));
		sourceLoginPanel.add(unlockedCourses);
		
		saveDir.add(saveDirField);
		saveDir.add(open);
		
		//JDialog panel zusammenbauen
		
		dialogPanel.add(sourceLoginPanel);
		dialogPanel.add(Box.createRigidArea(new Dimension(0,20)));
		dialogPanel.add(ucp);
		dialogPanel.add(saveDir);
		
		optionDialog.add(dialogPanel);		
	}
}
