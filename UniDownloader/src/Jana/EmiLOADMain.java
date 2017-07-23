package Jana;

import javax.swing.JFrame;

import java.io.IOException;


public class EmiLOADMain{

	public static void main(String[] args){
		EmiLOADView frame = new EmiLOADView();
		frame.setSize(1024,768);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
