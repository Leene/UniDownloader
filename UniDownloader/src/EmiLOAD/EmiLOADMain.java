package EmiLOAD;
import java.io.IOException;

import javax.swing.JFrame;


public class EmiLOADMain{
	
	public static void main(String[] args) throws IOException {
		EmiLOADView frame = new EmiLOADView();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);
	}

}
