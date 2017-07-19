package guiTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import guiTest.LoginEMIL;

public class TestLoginFrame extends JFrame {
	// Link zum original Beispiel
	// https://www.computerbase.de/forum/showthread.php?t=1456491
	// TODO ueberall mit Kommentar "// original" kann Zeile geloescht werden

	private JTextField nameField;
	private JPasswordField pwField;
	private JLabel wrongLabel = new JLabel("");
	private JTextArea textArea;
	private JPanel textPanel;

	private static final long serialVersionUID = 1L;
	private static String OK = "ok";

	public TestLoginFrame() {
		super("Einstellungen");
		setLayout(new FlowLayout());
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		add(mainPanel);

		textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(textPanel);

		// Komponenten
		JLabel nameLabel = new JLabel("Name: ");
		nameField = new JTextField(16);

		JLabel pwLabel = new JLabel("Passwort: ");
		pwField = new JPasswordField(16);

		JButton okBtn = new JButton("OK");
		okBtn.setActionCommand(OK);
		okBtn.addActionListener(new ButtonListener());

		mainPanel.add(nameLabel);
		mainPanel.add(nameField);
		mainPanel.add(pwLabel);
		mainPanel.add(pwField);
		mainPanel.add(okBtn);
		mainPanel.add(wrongLabel);
		
		

	//	textArea = new JTextArea(55, 60); // zeilen, reihe
	//	textArea.setBackground(Color.CYAN);
	//	textPanel.add(textArea);
		
	//	JScrollPane scrollPane = new JScrollPane();
	//	textArea.add(scrollPane);
	//	JScrollBar scrollBar = new JScrollBar();
	//	scrollPane.add(scrollBar);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 1000);// pack();
		setVisible(true);

	}

	// Textfeld Listener >>

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// ////Texteingabe erfassen////
			String enterName = nameField.getText();
			String enterPW;

			// ////////////////////////////

			String cmd = e.getActionCommand();

			if (OK.equals(cmd) || enterName != null) { // Process the password.
				char[] input = pwField.getPassword();
				enterPW = String.valueOf(input);
				System.out.println("enterPW" + enterPW);
				// ////Texteingabe dem LoginEMIL-Objekt als Parameter übergeben
				// ////

				 LoginEMIL login = new LoginEMIL(enterName, enterPW);
				// textPanel.add(login.getTextArea());
			//	 display.setEditable ( false ); // set textArea non-editable
			//	 textArea = new JTextArea(55, 60);
				 textArea = login.getTextArea();
				 ////////////////////
				 
				 JScrollPane scrollPane = new JScrollPane(textArea);
					scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				//	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					
					//textAreaReturn.add(scrollPane);
				//	JScrollBar scrollBar = new JScrollBar();
				//	scrollPane.add(scrollBar);
					
					textPanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );
					textPanel.add ( scrollPane );
					
				 ////////////////////////
				
				 //textPanel.add(textArea, FlowLayout.LEFT);
				 
				 
				 
				// textArea = new JTextArea(String.valueOf(login.getDoc()));  
				// textArea = new JTextArea(String.valueOf(login.getDoc()));   
				 
				// Zero out the possible password, for security.
				Arrays.fill(input, '0'); // weiß nicht obs geht 
				 pwField.selectAll(); // weiß nicht obs geht 
				// resetFocus(true);

			} else {
				wrongLabel.setText("Benutzername oder Passwort sind falsch.");
				add(wrongLabel);

			}
		}
		
		

		/*
		 * if (isPasswordCorrect(input)) {
		 * JOptionPane.showMessageDialog(controllingFrame,
		 * "Success! You typed the right password."); } else {
		 * JOptionPane.showMessageDialog(controllingFrame,
		 * "Invalid password. Try again.", "Error Message",
		 * JOptionPane.ERROR_MESSAGE); }
		 */

		// ////////////////////////////////////

	}

	public static void main(String[] args) {
		new TestLoginFrame();

	}

}
