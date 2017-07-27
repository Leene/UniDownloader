package controller;

 import view.BaseFrame;
 
 
//Diese Klasse (Controller) vereint das Grundfenster der GUI (Klasse BasefFrame) mit den Model ... TODO Kommentar erg�nzen
//Die Klasse BaseFrame baut Klassen (MenuBarFrame, baseFrameComponents) der View zusammen
//MenuBarFrame erweitert JMenuBar und beinhaltet alles was zur Men�leiste geh�rt 
//BaseFrameComponents erweitert JPanel und beinhaltet alle anderen Swing Komponenten des Hauptfensters

public class Controller {

	public Controller() {
		//MenuBarFrame menuBarFrame =	new MenuBarFrame();
		//BaseFrameComponents component =	new BaseFrameComponents();
		new BaseFrame();
		//new MenuBarFrame();
		//new BaseFrameComponents();
		
		
	}

}
