package view;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import view.BoardFrame;

public class BaseFrame extends BoardFrame {

	public BaseFrame(){

/////// MainMenueBar	
		JMenuBar menuBar = new JMenuBar();
		add(menuBar);

		JMenu menu = new JMenu("Menü");
		//menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Einstellungen ...");
		menu.add(menuItem);

		menu.addSeparator();
	
		JMenuItem menuItem2 = new JMenuItem("Beenden");
		menu.add(menuItem2);

		setJMenuBar(menuBar); // lässt Menüleiste anzeigen
		
////////// allgemeine Fenstereinstellungen
		// Beenden mit Fentsterschluss
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		pack();//setSize(300, 200); // Breite, Höhe in px
		setVisible(true); 
	}
	

}
