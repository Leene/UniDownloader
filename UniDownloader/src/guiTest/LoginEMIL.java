package guiTest;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;

public class LoginEMIL {
	Document doc2;

	public LoginEMIL(String un, String pw) {

		try {
			// Link der Hauptseite, wo auch der Login ist
			Connection.Response res = Jsoup
					.connect(
							"https://www.elearning.haw-hamburg.de/login/index.php")

					// TODO meinUsername + meinPW ausfuellen:
					.data("username", un, "password", pw).method(Method.POST)
					.execute();

			Document doc = res.parse();
			// Name des Cookies
			String sessionId = res.cookie("MoodleSession");
			// das wäre der Link zu den Feldern
			doc2 = Jsoup.connect("https://www.elearning.haw-hamburg.de/my/")
					.cookie("MoodleSession", sessionId).get();
			// Ausgabe der Seite in Konsole
			System.out.println(doc2);

		} catch (IOException e) {
			System.out.println("Login fehlgeschlagen");
		}

	}

	public Document getDoc() {

		return doc2;
	}

	public JTextArea getTextArea() {
		//
		JTextArea textAreaReturn = new JTextArea(String.valueOf(getDoc()));
		textAreaReturn.setPreferredSize(new Dimension(800, 600));
		textAreaReturn.setLineWrap(true);

		
		
		

		return textAreaReturn;
	}
}
