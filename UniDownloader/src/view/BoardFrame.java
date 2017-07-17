package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.BaseFrame;

public class BoardFrame extends JFrame{

	public BoardFrame() {
//		JPanel contentPanel = new JPanel();
		setLayout(new GridLayout());
//		
/////////////1. Panel Ebene		
		JPanel contentPanel = new JPanel(new BorderLayout());
		add(contentPanel);
/////////////2. Panel Ebene	
		JPanel listPanel = new JPanel(new GridLayout(1, 1, 10, 30));
		//(2, 3, 10, 30)=> (Elementanzahl der Reihe, ... 
		//der Spalte, Spaltenabstand (px?), Reihenabstand(px?))
		contentPanel.add(listPanel, BorderLayout.CENTER);
		
		JPanel buttomPanel = new JPanel(new FlowLayout());
		contentPanel.add(buttomPanel, BorderLayout.SOUTH);

/////////////3. Panel Ebene	
		JPanel subjectPanel = new JPanel(new BorderLayout());
		listPanel.add(subjectPanel);

/////////////4. Panel Ebene		
		JPanel rowPanel = new JPanel(new FlowLayout());
		subjectPanel.add(rowPanel);
		
///////////// Komponenten: 2. Panel Ebene 	
		
		JLabel mainTitleLabel = new JLabel("UniDownloader");
		contentPanel.add(mainTitleLabel, BorderLayout.NORTH);
		
		JButton checkBtn = new JButton("Alles markieren");
		JButton markBtn = new JButton("Markiertes downloaden");
		JButton allBtn = new JButton("Alle neuen/geänderten Dateien runterladen");
		
		buttomPanel.add(checkBtn);
		buttomPanel.add(markBtn);
		buttomPanel.add(allBtn);
		
///////////// Komponenten: 3. Panel Ebene 	
		
		JLabel headlineLabel = new JLabel("Kryptografie");
		subjectPanel.add(headlineLabel, BorderLayout.NORTH);		
		
///////////// Komponenten: 4. Panel Ebene		
		
		JCheckBox check = new JCheckBox(); 
		JLabel dataLabel = new JLabel("Dateiname.pdf");
		JLabel stateLabel = new JLabel("geändert");
		JButton button = new JButton("Download");
		
		rowPanel.add(check, FlowLayout.LEFT);
		rowPanel.add(dataLabel, FlowLayout.LEFT);
		rowPanel.add(stateLabel, FlowLayout.LEFT);
		rowPanel.add(button, FlowLayout.LEFT);
		
/////////////////////		
		
///////////// RowElemente für TEst
		
	JCheckBox check2 = new JCheckBox(); 
	JLabel dataLabel2 = new JLabel("Dateiname.pdf");
	JLabel stateLabel2 = new JLabel("geändert");
	JButton button2 = new JButton("Download");
	
	rowPanel.add(check2);
	rowPanel.add(dataLabel2);
	rowPanel.add(stateLabel2);
	rowPanel.add(button2);		
	
	JCheckBox check3 = new JCheckBox(); 
	JLabel dataLabel3 = new JLabel("Dateiname.pdf");
	JLabel stateLabel3 = new JLabel("geändert");
	JButton button3 = new JButton("Download");
	
	rowPanel.add(check3);
	rowPanel.add(dataLabel3);
	rowPanel.add(stateLabel3);
	rowPanel.add(button3);	
	
	JLabel headlineLabel2 = new JLabel("Kryptografie");
	subjectPanel.add(headlineLabel2);
	
	JCheckBox check4 = new JCheckBox(); 
	JLabel dataLabel4 = new JLabel("Dateiname.pdf");
	JLabel stateLabel4 = new JLabel("geändert");
	JButton button4 = new JButton("Download");
	
	rowPanel.add(check4);
	rowPanel.add(dataLabel4);
	rowPanel.add(stateLabel4);
	rowPanel.add(button4);
	
	JCheckBox check5 = new JCheckBox(); 
	JLabel dataLabel5 = new JLabel("Dateiname.pdf");
	JLabel stateLabel5 = new JLabel("geändert");
	JButton button5 = new JButton("Download");
	
	rowPanel.add(check5);
	rowPanel.add(dataLabel5);
	rowPanel.add(stateLabel5);
	rowPanel.add(button5);
		

	}

}
