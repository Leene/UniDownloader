package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class BaseFrameComponents extends JPanel {

	private static final long serialVersionUID = 995489539063780219L;

	int dataCount = 3;

	public BaseFrameComponents() {

		// ///////// UserName
		// setLayout(new BorderLayout());
		JLabel nameLabel = new JLabel("Marleen Stüber");
		// TODO name aus Variable, Schrift vergrößern
		// contentPanel.add(nameLabel, BorderLayout.NORTH);
		add(nameLabel, BorderLayout.NORTH);

		// JPanel coursePanel = new JPanel();
		JPanel coursePanel = new JPanel(new GridLayout(dataCount, 1, 0, 10));
		// (2, 3, 10, 30)=> (Elementanzahl der Reihe, ... der Spalte,
		// Spaltenabstand (px?), Reihenabstand(px?))

		coursePanel.setBorder(new TitledBorder(new EtchedBorder(),
				"Kryptografie"));
		// coursePanel.setPreferredSize(new Dimension(770, 100));
		// coursePanel.setMinimumSize(new Dimension(780, 100));
		coursePanel.setBackground(Color.CYAN);
		// coursePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(coursePanel);

		// /////////////////////////////
		JPanel dataPanel = new JPanel();
		dataPanel.setPreferredSize(new Dimension(750, 50));
		dataPanel.setBackground(Color.RED);
		// dataPanel.setLayout(new FlowLayout());
		coursePanel.add(dataPanel);

		JLabel dataLabel = new JLabel("Dateiname.pdf");
		// dataLabel.setSize(new Dimension(100, 50));
		dataPanel.add(dataLabel);
		// ////////////////////////////

		// /////////////////////////////
		JPanel dataPanel2 = new JPanel();
		dataPanel2.setPreferredSize(new Dimension(750, 50));
		dataPanel2.setBackground(Color.RED);
		// dataPanel.setLayout(new FlowLayout());
		coursePanel.add(dataPanel2);

		JLabel dataLabel2 = new JLabel("Dateiname.pdf");
		// dataLabel.setSize(new Dimension(100, 50));
		dataPanel2.add(dataLabel2);
		// ////////////////////////////

		// /////////////////////////////
		JPanel dataPanel3 = new JPanel();
		dataPanel3.setPreferredSize(new Dimension(750, 50));
		dataPanel3.setBackground(Color.RED);
		// dataPanel.setLayout(new FlowLayout());
		coursePanel.add(dataPanel3);

		JLabel dataLabel3 = new JLabel("Dateiname.pdf");
		// dataLabel.setSize(new Dimension(100, 50));
		dataPanel3.add(dataLabel3);
		// ////////////////////////////

	}

}
