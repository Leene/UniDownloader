import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class testEMIL {

	public testEMIL() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) throws IOException {
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		System.out.println("doc " + doc);

		Document doc2 = Jsoup.connect("https://www.elearning.haw-hamburg.de/").get();
		// liest alle html-elemente des login-divs aus:
		Elements newsHeadlines = doc2.select("#inst5282 div");

		System.out.println(newsHeadlines);
	}
}
