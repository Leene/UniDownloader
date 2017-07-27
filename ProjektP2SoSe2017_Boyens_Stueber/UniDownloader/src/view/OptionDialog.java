package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import controller.LoginListener;

public class OptionDialog extends JDialog {

	private static final long serialVersionUID = 3474295660468899170L;
	private String userID;
	private String passwordID;
	private String sourceURL;
	private String saveDirPath;
	private JTextField saveDirField;
	private JTextField sourceURLField;
	private JTextField userIDField;
	private JPasswordField passwordIDField;
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

	}
	
	public JTextField getUserIDField (){
		return userIDField;
	}
	
	public JPasswordField getPasswordIDField (){
		return passwordIDField;
	}
	
	
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
	
	
	
	
	
}
