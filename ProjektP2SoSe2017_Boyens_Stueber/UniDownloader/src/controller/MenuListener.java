package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.OptionDialog;

public class MenuListener implements ActionListener {

	public OptionDialog optionDialog;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 optionDialog = new OptionDialog("Einstellungen der Synchronisation", true);

	}
	
	
}
