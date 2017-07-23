package Jana;

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
	Elements titles;

	// TODO einzelne Daten saugen
	// String tagId,
	public String getScrapedSingleData(String un, String pw) throws Exception {
		// //////
		// File input = new File("/tmp/input.html");
		// Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		// ////////////////
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

			// ////////////////////////////////////////////////

			// Parsed den gesamten html Inhalt der class:"course_title"
			Elements kursIDs = doc2.getElementsByClass("course_title");

			// Filtert aus dem geparsden html Code alle a[href] tags
			Elements links = kursIDs.select("a[href]");

			// Selektiert aus den gefilterten Links nur den jeweiligen Titel
			 titles = kursIDs.select("a[href][title]");

			for (Element title : titles) {
				// System.out.println(t.attr("title"));
				String t = title.attr("title") + ";";
				String[] course = t.split(";");
				for (int i = 0; i < course.length; i++) {
					System.out.println(course[i]);
				}
			}
			// ///////////////////////////////////////////////////////////////

			StringBuilder sb = new StringBuilder();
			 sb.append(titles);
		//	sb.append(links);
			textOnly = Jsoup.parse(sb.toString()).text();
	//		System.out.println(kursIDs);
			// System.out.println("resultLinks" + resultLinks);

			// System.out.println(doc2);

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
		//
		// JTextArea textAreaReturn = new JTextArea(String.valueOf(getDoc()));
		JTextArea textAreaReturn = new JTextArea();
		// textAreaReturn.append(personName);
		 textAreaReturn.append(textOnly);

		textAreaReturn.setPreferredSize(new Dimension(800, 600));
		textAreaReturn.setLineWrap(true);

		return textAreaReturn;
	}

}

// ///////////////
/*
 * File input = new File("/tmp/input.html"); Document doc = Jsoup.parse(input,
 * "UTF-8", "http://example.com/");
 * 
 * Elements links = doc.select("a[href]"); // a with href Elements pngs =
 * doc.select("img[src$=.png]"); // img with src ending .png
 * 
 * Element masthead = doc.select("div.masthead").first(); // div with
 * class=masthead
 * 
 * Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
 */
// ///////////
