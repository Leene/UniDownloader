package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarFrame extends JMenuBar{
	
	private static final long serialVersionUID = 4605928153105426942L;

	public MenuBarFrame(){
	
			JMenu menu = new JMenu("Menü");
			// menu.setMnemonic(KeyEvent.VK_A);
			
			JMenuItem menuItem = new JMenuItem("Einstellungen ...");
			menu.add(menuItem);

			menu.addSeparator();

			JMenuItem menuItem2 = new JMenuItem("Beenden");
			menu.add(menuItem2);
			
			this.add(menu);
	
	}
}
