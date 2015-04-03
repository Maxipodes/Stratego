/**
 * 
 */
package main.AffGraph;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;




/**
 * @author Maxime
 *Cette classe permet la création d un objet Window qui est une fenetre 
 *dont on peut changer le conntenu
 */
public class Window extends JFrame {

	
	private JPanel[] panelDisplayer = new JPanel[3];      //Contient les différents panels a afficher
	private int currentPanel ;

	public static void main(String[] args) {
		new Window();

	}
	
	/**
	 * Cette classe est un listenner invoquant la méthode switchpanel a chaque pression de bouton 
	 * d un objet window
	 * @author Maxime
	 *
	 */
	public class SwitchListenner implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			Object source = e.getSource();
			JButton button = (JButton) source;
			
			if(button.getText()=="Retour")
				Window.this.switchPanel(-1);
			else
				Window.this.switchPanel(1);	
		}
	}
	
	/**
	 * Construit la fenetre de jeu de taille maximale
	 *
	 */
	
	public Window(){
		super();
		Rectangle bounds = getMaxBounds();
		super.setSize(bounds.width, bounds.height);
		super.setTitle("Stratego");
		super.setLocation(0, 0);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		super.setLocationRelativeTo(null);
		super.addWindowListener(new WindowAdapter(this));
		
		panelDisplayer[0] =  createMenu();
		panelDisplayer[1] =  createModSelect();
		panelDisplayer[2] = new MainPanel();
		currentPanel = 0;
	
		super.add(panelDisplayer[0]);
		super.paintComponents(getGraphics());
		
		
	
	}

	/**
	 * 
	 * @return la résolution maximum de l'écran
	 */
	private static Rectangle getMaxBounds(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		return gc.getBounds();
	}
	/**
	 * Methode qui permet de changer le contenu de l objet Window grace au panelDisplayer
	 * @param a -1 pour retourner au panel precedent , 1 pour passer au panel suivant
	 */
	
	private void  switchPanel(int a){
		super.getContentPane().remove(panelDisplayer[currentPanel]);
		currentPanel +=a;
		super.add(panelDisplayer[currentPanel]);
		super.validate();
		super.repaint();
	}
	
	/** crée un conteneur qui contient le menu principal
	 * @return un Jpannel 
	 */
	private JPanel createMenu(){
		JButton buttonPlay = new JButton("Jouer");
		buttonPlay.addActionListener(new SwitchListenner());
		JPanel panel=new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		panel.add(buttonPlay , c);    //Place le buttonPlay au centre du conteneur
		return panel;
	}
	

	/** crée un conteneur qui contient le panel des options de jeu
	 * @return un Jpannel
	 */
	private JPanel createModSelect(){
		JButton classicMod = new JButton("Mode Classic");
		JButton previousButton = new JButton("Retour");
		previousButton.addActionListener(new SwitchListenner());
		classicMod.addActionListener(new SwitchListenner());
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(classicMod, BorderLayout.CENTER);
		panel.add(previousButton, BorderLayout.WEST);
		return panel;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		panelDisplayer[2].paintComponents(g);
	}
}
