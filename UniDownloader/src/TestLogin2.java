
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TestLogin2 {
// Link zum original Beispiel https://www.computerbase.de/forum/showthread.php?t=1456491
// TODO ueberall mit Kommentar "// original" kann Zeile geloescht werden
	
	public static void main(String[] args) throws IOException {
		// Link der Hauptseite, wo auch der Login ist
		Connection.Response res = Jsoup.connect("https://www.elearning.haw-hamburg.de/login/index.php")
				
			// TODO meinUsername + meinPW ausfuellen:
				.data("username", "meinUsername", "password", "meinPW") 
				.method(Method.POST).execute();

		Document doc = res.parse();
		// Name des Cookies
		//String sessionId = res.cookie("PHPSESSID"); // original
		String sessionId = res.cookie("MoodleSession");
		// das wäre der Link zu den Feldern
		Document doc2 = Jsoup
			//	.connect("http://stuniverse.de/main.php?p=db&s=fl") // original
				.connect("https://www.elearning.haw-hamburg.de/my/")
				//.cookie("PHPSESSID", sessionId).get(); // original
				.cookie("MoodleSession", sessionId).get();
		// Ausgabe der Seite in Konsole
		System.out.println(doc2);

	}

}