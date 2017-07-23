import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BosLayoutTest extends JFrame {
	public static void main(String[] args) {
		new BosLayoutTest();
	}

	public BosLayoutTest() {
		setLayout(new FlowLayout());
	//	setLayout(new BorderLayout());

		

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(750, 200));
		panel.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("xfgn");
		label.setBackground(Color.BLUE);
		panel.add(label);
		
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(750, 50));
		panel2.setBackground(Color.GRAY);
		panel.add(panel2, BorderLayout.SOUTH);
		
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(750, 50));
		panel3.setBackground(Color.GRAY);
		panel.add(panel3);

		JButton q = new JButton("q");
		panel2.add(q);
		

		JButton e = new JButton("e");
		panel3.add(e);
		
		/////////////////////////
		JPanel panelB = new JPanel();
		panelB.setPreferredSize(new Dimension(750, 100));
		panelB.setBackground(Color.YELLOW);
		
		JLabel labelB = new JLabel("xfgn");
		labelB.setBackground(Color.RED);
		panelB.add(labelB);
		
		JPanel panel2B = new JPanel();
		panel2B.setPreferredSize(new Dimension(750, 50));
		panel2B.setBackground(Color.GRAY);
		panelB.add(panel2B, BorderLayout.SOUTH);
		
		JPanel panel3B = new JPanel();
		panel3B.setPreferredSize(new Dimension(750, 50));
		panel3B.setBackground(Color.GRAY);
		panelB.add(panel3B);

		JButton qB = new JButton("q");
		panel2B.add(qB);
		

		JButton eB = new JButton("e");
		panel3B.add(eB);
		
		
		

		// fügt die Hauptbox box dem Layout hinzu

		// fügt die Unterboxen der Hauptbox box hinzu
		// box.add(fontBox);
		// Abstandshalter von 10px Größe:
		// box.add(Box.createVerticalStrut(10));
		// box.add(buttonBox);
		// 7box.add(Box.createVerticalStrut(20));

		// fügt den Unterboxen editorBox, fontBox, buttonBox die Komponenten zu

	
		add(panel, BorderLayout.NORTH);
		add(panelB, BorderLayout.NORTH);
		
		
		



		// //////// allgemeine Fenstereinstellungen
		// Beenden mit Fentsterschluss
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600); // Breite, Höhe in px; pack();
		setVisible(true);

	}

}
