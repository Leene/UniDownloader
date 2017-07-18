
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestLogin  {

  private List<String> cookies;
  private HttpsURLConnection conn;

  private final String USER_AGENT = "Mozilla/5.0";

  public static void main(String[] args) throws Exception {
	  
	  /*
	To login a website, you need to know following values :

   1. Login form URL.
   "https://www.elearning.haw-hamburg.de/login/index.php"
   2. Login form data.
   "username:"
   "password:"
   3. URL for authentication.
   
   Host:www.elearning.haw-hamburg.de
   4. Http request / response header.

	   * 
	   * */

	//String url = "https://accounts.google.com/ServiceLoginAuth";
	//String gmail = "https://mail.google.com/mail/";
	
	String url = "https://www.elearning.haw-hamburg.de/login/index.php";
	String gmail = "https://www.elearning.haw-hamburg.de/my/";

	TestLogin http = new TestLogin();

	// make sure cookies is turn on
	CookieHandler.setDefault(new CookieManager());

	// 1. Send a "GET" request, so that you can extract the form's data.
	String page = http.GetPageContent(url);
	//String postParams = http.getFormParams(page, "username@gmail.com", "password");
	String postParams = http.getFormParams(page, "abj363", "fantaHAW1982");

	// 2. Construct above post's content and then send a POST request for
	// authentication
	http.sendPost(url, postParams);

	// 3. success then go to gmail.
	String result = http.GetPageContent(gmail);
	System.out.println(result);
  }

  private void sendPost(String url, String postParams) throws Exception {

	URL obj = new URL(url);
	conn = (HttpsURLConnection) obj.openConnection();

	// Acts like a browser
	conn.setUseCaches(false);
	conn.setRequestMethod("POST");
	conn.setRequestProperty("Host", "accounts.google.com");
	conn.setRequestProperty("User-Agent", USER_AGENT);
//	conn.setRequestProperty("Accept",
	//	"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	conn.setRequestProperty("Accept",
			"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
	
	//conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	conn.setRequestProperty("Accept-Language", "de-DE,de;q=0.8,en-US;q=0.6,en;q=0.4");
	
	for (String cookie : this.cookies) {
		conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
	}
	conn.setRequestProperty("Connection", "keep-alive");
	//conn.setRequestProperty("Referer", "https://accounts.google.com/ServiceLoginAuth");
	conn.setRequestProperty("Referer", "https://www.elearning.haw-hamburg.de/login/index.php");
	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); // entspricht emil
	conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));

	conn.setDoOutput(true);
	conn.setDoInput(true);

	// Send post request
	DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	wr.writeBytes(postParams);
	wr.flush();
	wr.close();

	int responseCode = conn.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + postParams);
	System.out.println("Response Code : " + responseCode);

	BufferedReader in =
             new BufferedReader(new InputStreamReader(conn.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();
	// System.out.println(response.toString());

  }

  private String GetPageContent(String url) throws Exception {

	URL obj = new URL(url);
	conn = (HttpsURLConnection) obj.openConnection();

	// default is GET
	conn.setRequestMethod("GET");

	conn.setUseCaches(false);

	// act like a browser
	conn.setRequestProperty("User-Agent", USER_AGENT);
	//conn.setRequestProperty("Accept",
	//	"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	conn.setRequestProperty("Accept",
			"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
	
	//conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	conn.setRequestProperty("Accept-Language", "de-DE,de;q=0.8,en-US;q=0.6,en;q=0.4");
	
	if (cookies != null) {
		for (String cookie : this.cookies) {
			conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
		}
	}
	int responseCode = conn.getResponseCode();
	System.out.println("\nSending 'GET' request to URL : " + url);
	System.out.println("Response Code : " + responseCode);

	BufferedReader in =
            new BufferedReader(new InputStreamReader(conn.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();

	// Get the response cookies
	setCookies(conn.getHeaderFields().get("Set-Cookie"));

	return response.toString();

  }
  String username = "abj363";
  String password = "fantaHAW1982";
  public String getFormParams(String html, String username, String password)
		throws UnsupportedEncodingException {

	System.out.println("Extracting form's data...");

	Document doc = Jsoup.parse(html);

	// Google form id
	// Element loginform = doc.getElementById("gaia_loginform");
	Element loginform = doc.getElementById("form-input");
	Elements inputElements = loginform.getElementsByTag("input"); // EMIL entspricht Beispiel
	List<String> paramList = new ArrayList<String>();
//	for (Element inputElement : inputElements) {
	//	String key = inputElement.attr("name");
	//	String value = inputElement.attr("value");
		
	//7	String key = inputElement.attr("username");
	//	String value = inputElement.attr("value");
		
/*
		//if (key.equals("Email"))
		if (key.equals("Anmeldename"))
			value = username;
		//else if (key.equals("Passwd"))
		else if (key.equals("Kennwort"))
			value = password;
		paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
		
	*/
	
	//}

	// build parameters list
	StringBuilder result = new StringBuilder();
	for (String param : paramList) {
		if (result.length() == 0) {
			result.append(param);
		} else {
			result.append("&" + param);
		}
	}
	return result.toString();
  }

  public List<String> getCookies() {
	return cookies;
  }

  public void setCookies(List<String> cookies) {
	this.cookies = cookies;
  }

}