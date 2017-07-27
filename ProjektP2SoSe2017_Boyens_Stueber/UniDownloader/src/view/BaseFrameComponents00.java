package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

//import model.TestArrayList;

public class BaseFrameComponents00 extends JPanel {

	private static final long serialVersionUID = 995489539063780219L;

	// Variablen
	private int dataCount;
	private int dirHeight;
	private int courseHeight;

	// die Höhe von dataCountPanel ist fixiert (750, 50)
	// die Höhe von dirPanel ergibt sich u.a. aus der Anzahl der dataPanels
	// die Höhe von	coursePanel ergibts sich aus u.a. dirPanel
			
	private JPanel dirPanel = new JPanel();
	private JPanel dataPanel = new JPanel();
	private JPanel coursePanel;
	private JPanel accountPanel = new JPanel();

	public BaseFrameComponents00() {
	//	TestArrayList test = new TestArrayList();
		
	//	dataCount = test.getDataCount();
	//	dirHeight = test.getdirHeight();
	//	courseHeight = test.getCourseHeight();
		
//		System.out.println("Q dataCount" + dataCount);
//		System.out.println("Q dirHeight" + dirHeight);
//		System.out.println("Q courseHeight" + courseHeight);
		
		setLayout(new BorderLayout());

		accountPanel.setPreferredSize(new Dimension(800, 1300));
		add(accountPanel);

		// ///////// UserName
		JLabel nameLabel = new JLabel("User Name");
		// TODO name aus Variable, Schrift vergrößern
		accountPanel.add(nameLabel, BorderLayout.NORTH);



		createCoursePanel(600);
		//createCoursePanel(courseHeight);
		createDirPanel(dirHeight);
		createDataPanel(dataCount);

	}// Konstruktor

	public void createCoursePanel(int height) {

		coursePanel = new JPanel(new FlowLayout());
		coursePanel.setBorder(new TitledBorder(new EtchedBorder(),
				"Kryptografie"));
		coursePanel.setPreferredSize(new Dimension(770, height)); // HÖhe

		coursePanel.setBackground(Color.CYAN);
		accountPanel.add(coursePanel);
		
	}

	public void createDirPanel(int height) {
	//	dirPanel = new JPanel();
		dirPanel = new JPanel(new FlowLayout());
		dirPanel.setPreferredSize(new Dimension(750, height)); // dirHeight));
		dirPanel.setBackground(Color.GREEN);
		coursePanel.add(dirPanel);
		
		JLabel dirLabel = new JLabel("Vorlesung 1");
		dirPanel.add(dirLabel);
	}

	public void createDataPanel(int anzahl) {

		for (int a = 0; a < anzahl; a++) {
			dataPanel = new JPanel(new FlowLayout());
			dataPanel.setPreferredSize(new Dimension(750, 50));
			dataPanel.setBackground(Color.WHITE);
			dirPanel.add(dataPanel);

			JLabel dataLabel = new JLabel("Dateiname.pdf"); //
			dataPanel.add(dataLabel);

		}
	}

}
