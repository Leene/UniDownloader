import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;  

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	
	}
public static void main(String[] args) throws IOException{
	String html = "<html><head><title>First parse</title></head>"
			  + "<body><p>Parsed HTML into a doc.</p></body></html>";
			Document doc = Jsoup.parse(html);
			System.out.println("doc " + doc);
	
	Document doc2 = Jsoup.connect("http://en.wikipedia.org/").get();
	Elements newsHeadlines = doc2.select("#mp-itn b a");
	
	System.out.println(newsHeadlines);
}
}
