package view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import java.awt.Color;


import view.MenuBarFrame;

// Diese Klasse (BaseFrame) baut Klassen (MenuBarFrame, baseFrameComponents)  der View zusammen
// MenuBarFrame erweitert JMenuBar und beinhaltet alles was zur Emnüleiste gehört 
// BaseFrameComponents erweitert JPanel und beinhaltet alle anderen Swing Komponenten des Hauptfensters

public class BaseFrame extends JFrame {

	private static final long serialVersionUID = 1637266512734730868L;

	public BaseFrame() {
		setTitle("UniDownloader");
		
		JMenuBar menuBar = new MenuBarFrame();
		setJMenuBar(menuBar);

		JPanel baseFrameComponents = new BaseFrameComponents();
		baseFrameComponents.setBackground(Color.ORANGE);
		add(baseFrameComponents);

		// //////// allgemeine Fenstereinstellungen
		// Beenden mit Fentsterschluss
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600); // Breite, Höhe in px; pack();
		setVisible(true);
	}

}
