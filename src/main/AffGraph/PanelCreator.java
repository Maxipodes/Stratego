/**
 * 
 */
package main.AffGraph;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Maxime
 *
 */
public class PanelCreator {
	
	/**
	 * @return un conteneur qui contient le menu principal
	 */
	public static JPanel createMenu(Window wdw){
		JButton buttonPlay = new JButton("Jouer");
		buttonPlay.addActionListener(new SwitchListenner(wdw));
		JPanel panel=new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		panel.add(buttonPlay , c);    //Place le buttonPlay au centre du conteneur
		return panel;
	}
	

	/**
	 * @return un conteneur qui contient le panel des options de jeu
	 */
	public static JPanel createModSelect(Window wdw){
		JButton classicMod = new JButton("Mode Classic");
		JButton previousButton = new JButton("Retour");
		previousButton.addActionListener(new SwitchListenner(wdw));
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(classicMod, BorderLayout.CENTER);
		panel.add(previousButton, BorderLayout.WEST);
		return panel;
	}

}
