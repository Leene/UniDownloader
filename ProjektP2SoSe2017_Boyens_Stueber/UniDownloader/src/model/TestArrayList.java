package model;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

	ArrayList<String> nwi1;
	ArrayList<String> nwi2;
	ArrayList<String> ti1;
	ArrayList<ArrayList> nwi;
	ArrayList<ArrayList> ti;
	ArrayList<ArrayList> account;
	
	private int courseHeight;
	private int dirHeight;
	private int dataCount;
	private int dirCount;
	

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
	//	System.out.println("nwi ArrayList: " + nwi + "Anzahl" + nwi.size());
	//	System.out.println("nwi1 ArrayList: " + nwi1 + "Anzahl" + nwi1.size());
	//	System.out.println("nwi2 ArrayList: " + nwi2 + "Anzahl" + nwi2.size());
	//	System.out.println("ti ArrayList: " + ti + "Anzahl" + ti.size());
	//	System.out.println("ti1 ArrayList: " + ti1 + "Anzahl" + ti1.size());
	
		System.out.println("genaue ArrayList: " + account.get(0).get(1)); // entspricht nwi.get(1)
		
		dirCount = nwi.size();
	
		dataCount = nwi1.size();
		System.out.println("dataCount" + dataCount);
		System.out.println("dirCount" + dirCount);
		
		
		if (1 < dataCount){
		//	dirHeight = dataCount * 50 + dirCount * 15 + dataCount* 5;	//(dataCount-1)
			
			dirHeight = dataCount * 50 + 31 + (dataCount-1)* 5;
			System.out.println("if");
		}else{
			//dirHeight = dataCount * 50 + dirCount * 15;
			dirHeight = dataCount * 50 + 31;
			System.out.println("else");
		}
				
				
		System.out.println("dirHeight" + dirHeight);
		
		courseHeight = dirHeight + account.size() + 20;
		System.out.println("courseHeight" + courseHeight);
		

	}
	
	public int getCourseHeight() {
		return courseHeight;
	}
	
	public int getdirHeight() {
		return dirHeight;
	}
	
	public int getDirCount() {

		return dirCount;
	}
	
	public int getDataCount() {
		return dataCount;
	}
	
	

}
