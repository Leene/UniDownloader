package EmiLOAD;
import javax.swing.JFrame;

import java.io.IOException;


public class EMILoadMAIN{

	public static void main(String[] args){
		EMILoadVIEW frame = new EMILoadVIEW();
		frame.setSize(1024,768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
