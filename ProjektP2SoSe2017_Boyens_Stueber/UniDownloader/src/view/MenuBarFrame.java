package view;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.MenuListener;

public class MenuBarFrame extends JMenuBar {
	
	private static final long serialVersionUID = 4605928153105426942L;
	
	JMenu menu;
	JMenuItem options, close;

	public MenuBarFrame() {
		/*
		 * JMenu menu = new JMenu("Menü"); // menu.setMnemonic(KeyEvent.VK_A);
		 * 
		 * JMenuItem menuItem = new JMenuItem("Einstellungen ...");
		 * menu.add(menuItem);
		 * 
		 * menu.addSeparator();
		 * 
		 * JMenuItem menuItem2 = new JMenuItem("Beenden"); menu.add(menuItem2);
		 * 
		 * this.add(menu);
		 */

		// Menubar erstellen, mit Menu "Bearbeiten" und dessen MenuItems
		// "Optionen" und "Schließen" füllen
	
		menu = new JMenu("Bearbeiten");
		options = new JMenuItem("Optionen");
		options.addActionListener(new MenuListener());
		close = new JMenuItem("Schließen");

		this.add(menu);
		menu.add(options);
		menu.add(close);

	}
	
	
}
