package view;
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

public class BaseFrameComponents extends JPanel{
	
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
	ArrayList<String> arrayListCourses;
	JCheckBox boxes;
	String[] check;
	
	
	
	public BaseFrameComponents() {
		

		JPanel idPanel = new JPanel();
		JLabel courseLabel = new JLabel("Angemeldete Kurse zum Synchronisieren von " + userIDField.getText());
		
		JPanel coursePanel = new JPanel();
		coursePanel.setPreferredSize(new Dimension(400,400));
				
		coursePanel.setBackground(Color.DARK_GRAY);
		idPanel.add(courseLabel);
		coursePanel.add(idPanel, BorderLayout.NORTH);
		
		add(menubar, BorderLayout.NORTH);
		add(coursePanel, BorderLayout.CENTER);
		
		
		
		
	} // Ende Konstruktor


}


//TODO GLOBALE GEDANKENSTÜTZE! 
//TextField der Source URL muss auf not editable gesetzt werden
//FileChooser ActionListener reparieren
//MVC in irgendeiner Form nutzen (fast 300 Zeilen sind ein kleines bisschen zu viel)
//Dialog hängt nicht mit dem richtigen Hauptfenster zusammen, nur mit Testfenster