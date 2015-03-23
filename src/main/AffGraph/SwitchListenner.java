package main.AffGraph;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class SwitchListenner implements ActionListener{
	
	Window frame;
	
	public SwitchListenner(Window frm){
		frame = frm;
	}
	
	public void actionPerformed(ActionEvent e){
		if(((JButton) e.getSource()).getText()=="Retour")
			frame.switchPanel(-1);
		else
			frame.switchPanel(1);
			
	}
	

}
