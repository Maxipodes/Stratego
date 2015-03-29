package main.AffGraph;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Cette classe est un listenner invoquant la m�thode switchpanel a chaque pression de bouton 
 * d un objet window
 * @author Maxime
 *
 */
public class SwitchListenner implements ActionListener{
	
	Window window;
	
	public SwitchListenner(Window wdw){
		window = wdw;
	}
	
	public void actionPerformed(ActionEvent e){
		if(((JButton) e.getSource()).getText()=="Retour")
			window.switchPanel(-1);
		else
			window.switchPanel(1);
			
	}
	

}
