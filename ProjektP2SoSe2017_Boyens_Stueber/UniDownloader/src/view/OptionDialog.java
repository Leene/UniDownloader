package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import controller.CheckListener;
import controller.LoginListener;

public class OptionDialog extends JDialog {

	private static final long serialVersionUID = 3474295660468899170L;
	private String userID;
	private String passwordID;
	private String sourceURL;
	private String saveDirPath;
	private JTextField saveDirField;
	private JTextField sourceURLField;
	  public JTextField userIDField;
	  public JPasswordField passwordIDField;
	private JPanel dialogPanel;
	private JPanel sourceLoginPanel;
	private JPanel loginPanel;
	private JPanel unlockedCoursesPanel;
	private JPanel saveDir;
	private JPanel dialogResult;
	private JScrollPane ucp;
	private JLabel userIDLabel;
	private JLabel passwordIDLabel;
	private JLabel unlockedCourses;
	private JButton submit;
	private JButton open;
	private JButton saveDialog;
	private JButton cancelDialog;
	private JDialog optionDialog;
	private ArrayList<String> arrayListCourses;
	private JCheckBox boxes;
	private String[] check;
	
	@SuppressWarnings("static-access")
	public OptionDialog(String title, boolean modal) {
		setTitle(title);
		
		// Die URL festlegen, die geparsed werden und als Hauptnavigation werden soll
		// Als Variable, damit sie im Falle einer Veränderung schnell angepasst werden kann
		sourceURL = "https://www.elearning.haw-hamburg.de/login/index.php";

		// Dialog mit einem Panel versehen, dass alle anderen Komponenten
		// beinhaltet
		dialogPanel = new JPanel();

		// Erstes Panel: SourceURL und Login mit Submit Button
		sourceLoginPanel = new JPanel();
		sourceURLField = new JTextField(sourceURL);
		loginPanel = new JPanel();
		userIDLabel = new JLabel("Benutzername");
		userIDField = new JTextField(10);
		passwordIDLabel = new JLabel("Passwort");
		passwordIDField = new JPasswordField(10);
		submit = new JButton("submit");
		submit.addActionListener(new LoginListener()); // TODO submit reparieren

		// Angemeldeten Kurse in ScrollPane, Checkboxen zum auswählen der Kurse
		unlockedCoursesPanel = new JPanel();
		ucp = new JScrollPane(unlockedCoursesPanel);
		unlockedCourses = new JLabel("Angemeldete Kurse von " + userID);

		// FileChooser mit Klick auf "searchBtn", um den Speicherort der
		// Downloads zu bestimmen
		saveDir = new JPanel();
		saveDirField = new JTextField(10);
		open = new JButton("Öffnen");
		open.addActionListener(new OpenListener());

		// Änderungen, die über den Dialog vorgenommen wurden, übernehmen oder
		// abbrechen
		dialogResult = new JPanel();
		saveDialog = new JButton("Übernehmen");
		cancelDialog = new JButton("Abbrechen");

		// #################################################################################

		// Layout für Hauptpanel im Dialog festlegen, BoxLayout von oben nach
		// unten
		dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.PAGE_AXIS));

		// Das erste Panel im Dialog, BoyLayout (v.o.n.u.), loginPanel mit
		// GridLayout integriert
		sourceLoginPanel.setLayout(new BoxLayout(sourceLoginPanel,
				BoxLayout.PAGE_AXIS));
		loginPanel.setLayout(new GridLayout(2, 2));

		// Scrollbalken an der Seite und preferierte Größe des Panels für
		// Scrollpane festlegen
		ucp.setVerticalScrollBarPolicy(ucp.VERTICAL_SCROLLBAR_ALWAYS);
		ucp.setPreferredSize(new Dimension(200, 250));
		unlockedCoursesPanel.setLayout(new BoxLayout(unlockedCoursesPanel,
				BoxLayout.Y_AXIS));
		ucp.setVisible(true);

		// Layout vom Filechooser Panel
		saveDir.setLayout(new FlowLayout());

		// Layout vom letzten Panel zur Übernahme der Angaben
		dialogResult.setLayout(new FlowLayout());

		// //////// Adden der Komponeneten
		/*
		 * JPanel idPanel = new JPanel(); JLabel courseLabel = new
		 * JLabel("Angemeldete Kurse zum Synchronisieren von " +
		 * userIDField.getText());
		 * 
		 * JPanel coursePanel = new JPanel(); coursePanel.setPreferredSize(new
		 * Dimension(400,400));
		 * 
		 * coursePanel.setBackground(Color.DARK_GRAY); idPanel.add(courseLabel);
		 * coursePanel.add(idPanel, BorderLayout.NORTH);
		 * 
		 * 
		 * add(coursePanel, BorderLayout.CENTER);
		 */
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

		// JDialog panel zusammenbauen

		dialogPanel.add(sourceLoginPanel);
		dialogPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		dialogPanel.add(ucp);
		dialogPanel.add(saveDir);

		add(dialogPanel);

		// #######################################################

		setSize(600, 600);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		
//////////////////Listener
arrayListCourses = new ArrayList<String>();

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
			for (Element title: titles){
				// System.out.println(t.attr("title"));
				String t = title.attr("title") + ";";
				String[] course = t.split(";");
					for (int i = 0; i < course.length; i++) {
						arrayListCourses.add(course[i]);
						boxes = new JCheckBox(course[i]);
						boxes.addItemListener(new CheckListener());
						unlockedCoursesPanel.add(boxes);
						unlockedCoursesPanel.revalidate();									
						
						boxes.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								
							}
						});
					}
			}
			
			System.out.println(" fertige arrayListCourse: "+ arrayListCourses + "Anzahl: " + arrayListCourses.size());
//			System.out.println(" fertige arrayListCourse: "+ arrayListCourses + "Anzahl: " + arrayListCourses.size());
//			System.out.println("4. Element: "+ arrayListCourses.get(3));
	
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


		
		
	}// Konstruktor
	
	/*
	public String getUserIDField (){
		return userIDField.getText();
	}
	
	public String getPasswordIDField (){
		return passwordIDField.getText();
		
	}
	*/
	
	public String getSourceURL (){
		return sourceURL;
	}
	
	public ArrayList<String> getArrayListCourses (){
		return arrayListCourses;
	}
	
	
	
	public JPanel getUnlockedCoursesPanel (){
		return unlockedCoursesPanel;
	}
	
	public JButton getSubmitBtn() {
		return submit;
	}
	

	public class OpenListener implements ActionListener {
		
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
	  	//TODO Durch Verändern des ActionListeners Fehler ausgelöst
	  	if (saveDirChooser.showSaveDialog(OptionDialog.this) == JFileChooser.APPROVE_OPTION) { 
	  		System.out.println("getCurrentDirectory(): " 
	  				+  saveDirChooser.getCurrentDirectory());
	  		System.out.println("getSelectedFile() : " 
	  				+  saveDirChooser.getSelectedFile());
	  		saveDirField.setText(saveDirChooser.getSelectedFile().getPath());
	  	}
	  	else {
	  		System.out.println("No Selection ");
	  	}
	  }
	
public class CheckListener implements ItemListener {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
			            //TODO Index der Checkbox mit Index der Kurslinks abgleichen
						//Über Kurslinks Dateien des Kurses parsen 
						//Data und Ordner runterladen
						//Benötigt: Arraylist Kurslinks
			        } else {//checkbox has been deselected
			            //do nothing
			        	//User darüber informieren, dass er einen Kurs wählen muss
			        };			
				}
			}
	
}
}