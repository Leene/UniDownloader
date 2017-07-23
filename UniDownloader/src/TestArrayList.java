import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
	
	
	public static void main(String[] args) {
		new TestArrayList();
	}

	ArrayList<String> nwi1;
	ArrayList<String> nwi2;
	ArrayList<String> ti1;
	ArrayList<ArrayList> nwi;
	ArrayList<ArrayList> ti;
	ArrayList<ArrayList> account;
	
	public TestArrayList() {

		// //////Daten kurs NWI///////////
		ArrayList<String> nwi1 = new ArrayList<String>();
		nwi1.add("a");
		nwi1.add("b");
		nwi1.add("c");
		nwi1.add("d");
		nwi1.add("e");
		nwi1.add("f");

		ArrayList<String> nwi2 = new ArrayList<String>();
		nwi2.add("v2a");
		nwi2.add("v2b");
		nwi2.add("v2c");

		// //////Daten kurs TI///////////
		ArrayList<String> ti1 = new ArrayList<String>();
		ti1.add("v1a");
		ti1.add("v1b");
		ti1.add("v1c");

		// /////Kurs ArrayList/////////
		ArrayList<ArrayList> nwi = new ArrayList<ArrayList>();
		nwi.add(nwi1);
		nwi.add(nwi2);

		ArrayList<ArrayList> ti = new ArrayList<ArrayList>();
		ti.add(ti1);

		ArrayList<ArrayList> account = new ArrayList<ArrayList>();
		account.add(nwi);
		account.add(ti);

		System.out.println("account ArrayList: " + account + "Anzahl"+ account.size());
		System.out.println("nwi ArrayList: " + nwi + "Anzahl" + nwi.size());
		System.out.println("nwi1 ArrayList: " + nwi1 + "Anzahl" + nwi1.size());
		System.out.println("nwi2 ArrayList: " + nwi2 + "Anzahl" + nwi2.size());
		System.out.println("ti ArrayList: " + ti + "Anzahl" + ti.size());
		System.out.println("ti1 ArrayList: " + ti1 + "Anzahl" + ti1.size());

	}
	
	public int getDataHeight() {
		
		int dataHeight = ti1.size() + nwi2.size() + nwi1.size();
		return dataHeight;
	}

}
