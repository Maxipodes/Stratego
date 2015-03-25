package main.AffGraph;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


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
