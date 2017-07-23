package EmiLOAD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class OpenButton extends EMILoadVIEW implements ActionListener {

	@Override
    public void actionPerformed(ActionEvent openKlicked){	
    	JFileChooser saveDirChooser = new JFileChooser(); 
    	saveDirChooser.setCurrentDirectory(new java.io.File("."));
    	saveDirChooser.setDialogTitle(saveDirPath);
    	saveDirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    	//
    	// disable the "All files" option.
    	//
    	saveDirChooser.setAcceptAllFileFilterUsed(false);
    	//    
    	if (saveDirChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) { 
    		System.out.println("getCurrentDirectory(): " 
    				+  saveDirChooser.getCurrentDirectory());
    		System.out.println("getSelectedFile() : " 
    				+  saveDirChooser.getSelectedFile());
    		saveDirField.setText(saveDirChooser.getSelectedFile().getPath());
    	}
    	else {
    		System.out.println("No Selection ");
    	}
    };
}