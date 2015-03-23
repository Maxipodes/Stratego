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
public class Displayer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private JPanel[] panelDisplayer = new JPanel[2];      //Contient les différents conteneurs a afficher
	private int currentPanel ;
	static Window window;
	
	public Displayer(){
		window = new Window();
		panelDisplayer[0] =  createMenu();
		panelDisplayer[1] =  createModSelect();
		currentPanel = 0;
	}
	
	public void  switchPanel(int a){
		window.remove(panelDisplayer[currentPanel]);
		currentPanel +=a;
		window.add((panelDisplayer[currentPanel]));
	}
	/**
	 * @param null
	 * @return un conteneur qui contient le menu principal
	 */
	private static JPanel createMenu(){
		JButton buttonPlay = new JButton("Jouer");
		buttonPlay.addActionListener(new SwitchListenner(window));
		JPanel panel=new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		panel.add(buttonPlay , c);    //Place le buttonPlay au centre du conteneur
		return panel;
	}
	
	private static JPanel createModSelect(){
		JButton classicMod = new JButton("Mode Classic");
		JButton previousButton = new JButton("Retour");
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(classicMod, BorderLayout.CENTER);
		panel.add(previousButton, BorderLayout.WEST);
		return panel;
	}
}
