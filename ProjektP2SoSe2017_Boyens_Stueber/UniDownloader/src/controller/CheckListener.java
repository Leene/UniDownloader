package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
            //TODO Index der Checkbox mit Index der Kurslinks abgleichen
			//�ber Kurslinks Dateien des Kurses parsen 
			//Data und Ordner runterladen
			//Ben�tigt: Arraylist Kurslinks
        } else {//checkbox has been deselected
            //do nothing
        	//User dar�ber informieren, dass er einen Kurs w�hlen muss
        };			
	}
}