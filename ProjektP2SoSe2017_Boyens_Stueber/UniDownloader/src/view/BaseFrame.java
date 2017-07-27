package view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;



import java.awt.Dimension;
import java.io.IOException;

import view.MenuBarFrame;

// Diese Klasse (BaseFrame) baut Klassen (MenuBarFrame, baseFrameComponents)  der View zusammen
// MenuBarFrame erweitert JMenuBar und beinhaltet alles was zur Emnüleiste gehört 
// BaseFrameComponents erweitert JPanel und beinhaltet alle anderen Swing Komponenten des Hauptfensters

public class BaseFrame extends JFrame {

	private static final long serialVersionUID = 1637266512734730868L;
	public JMenuBar menuBar;
	public BaseFrame() {
		setTitle("UniDownloader");
		
		 menuBar = new MenuBarFrame();
		setJMenuBar(menuBar);

		JPanel baseFrameComponents = new BaseFrameComponents();
		baseFrameComponents.setBackground(Color.ORANGE);
		add(baseFrameComponents);
		
		JScrollPane scrollPane = new JScrollPane(baseFrameComponents);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		scrollPane.getViewport().add(baseFrameComponents);
		
	
			System.out.println("Baseframe");

		// //////// allgemeine Fenstereinstellungen
		// Beenden mit Fentsterschluss
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 900); // Breite, Höhe in px; pack();
		setVisible(true);
	}
	
	

}
