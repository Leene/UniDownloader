package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.JCheckBox;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import view.OptionDialog;

public class LoginListener extends MenuListener implements ActionListener {
	private String userID;
	private String passwordID;


	public void actionPerformed(ActionEvent submitKlicked) {
		System.out.println("optionDialog.getUserIDField().getText()" + optionDialog.getUserIDField().getText());
		userID = optionDialog.getUserIDField().getText();
		// userID = getUserIDField().getText();
		passwordID = optionDialog.getPasswordIDField().getText();

		
		try {
			Connection.Response res = Jsoup
					.connect(optionDialog.getSourceURL())
					// TODO für "username" den Input des userID String
					// TODO für "password" den Input des passwordID String
					.data("username", userID, "password", passwordID)
					.method(Method.POST).execute();

			Document doc = res.parse();
			String sessionId = res.cookie("MoodleSession");

			Document doc2 = Jsoup
					.connect("https://www.elearning.haw-hamburg.de/my/")
					.cookie("MoodleSession", sessionId).get();

			// Parsed den gesamten html Inhalt der class:"course_title"
			Elements kursIDs = doc2.getElementsByClass("course_title");

			// Filtert aus dem geparsden html Code alle a[href] tags
			Elements links = kursIDs.select("a[href]");

			// Selektiert aus den gefilterten Links nur den jeweiligen Titel
			Elements titles = kursIDs.select("a[href][title]");
			for (Element title : titles) {
				// System.out.println(t.attr("title"));
				String t = title.attr("title") + ";";
				String[] course = t.split(";");
				for (int i = 0; i < course.length; i++) {
					optionDialog.getArrayListCourses().add(course[i]);
					JCheckBox boxes = new JCheckBox(course[i]);
				//	boxes.addItemListener(new CheckListener());
					optionDialog.getUnlockedCoursesPanel().add(boxes);
					optionDialog.getUnlockedCoursesPanel().revalidate();

					boxes.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

						}
					});
				}
			}

			System.out.println(" fertige arrayListCourse: "
					+ optionDialog.getArrayListCourses() + "Anzahl: "
					+ optionDialog.getArrayListCourses().size());
			// System.out.println(" fertige arrayListCourse: "+ arrayListCourses
			// + "Anzahl: " + arrayListCourses.size());
			// System.out.println("4. Element: "+ arrayListCourses.get(3));

			// Selektiert aus den gefilterten Links nur die URL
			// http://(...).id=xyz
			for (Element link : links) {
				String l = link.attr("href");
				if (l.length() > 0) {
					if (l.length() < 4)
						l = doc.baseUri() + l.substring(1);
					else if (!l.substring(0, 4).equals("http"))
						l = doc.baseUri() + l.substring(1);
				}
				System.out.println(l);
			}
		} catch (IOException submitKlicked1) {
			System.out.println("Fehler");
		}

	}
}
