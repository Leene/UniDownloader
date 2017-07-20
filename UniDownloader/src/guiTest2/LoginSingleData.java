package guiTest2;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextArea;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LoginSingleData {
	Document doc2;
	String textOnly;
	Elements personName;

	// TODO einzelne Daten saugen
	public String getScrapedSingleData(String un, String pw) throws Exception {
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

			Elements links = doc.select("a[href]"); // a with href
			Elements personName = doc2.select("h1");
	
			StringBuilder sb = new StringBuilder();
			// sb.append(links);
			sb.append(personName);
			textOnly = Jsoup.parse(sb.toString()).text();
			System.out.println(textOnly);

		} catch (IOException e) {
			System.out.println("Login fehlgeschlagen");
		}

		String data = "";
		return data;
	}

	// TODO einzelne Daten von bestimmter URL saugen
	public String getScrapedDataFromURL(String tagId, String url) {
		String data = "";
		return data;
	}

	// TODO url aus Link saugen
	public String getURL() {
		String url = "";
		return url;
	}

	public Document getDoc() {
		return doc2;
	}

	public JTextArea getTextArea() {

		JTextArea textAreaReturn = new JTextArea(textOnly);
		textAreaReturn.setPreferredSize(new Dimension(800, 600));
		textAreaReturn.setLineWrap(true);

		return textAreaReturn;
	}
}