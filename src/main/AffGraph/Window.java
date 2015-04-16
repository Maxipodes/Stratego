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

import main.AffGraph.ButtonMod.ButtonMod;
import main.AffGraph.ButtonMod.ClassicButton;
import main.AffGraph.GameMod.GameMod;
import main.AffGraph.Panel.MainPanel;
import main.AffGraph.Panel.PlacementPanel;


/**
 * @author Maxime
 *Cette classe permet la création d un objet Window qui est une fenetre 
 *dont on peut changer le conntenu
 */
public class Window extends JFrame {

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
	
	public class ModListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			MainPanel mp =mainPanel;
			ButtonMod bm =(ButtonMod) e.getSource();
			GameMod mod = bm.getMod();
			mp.GAME_PANEL.setBoardGame(mod.getBoardGame());
		}
	}
	
	public JPanel[] panelDisplayer = new JPanel[4];      //Contient les différents panels a afficher
	private int currentPanel ;
	private MainPanel mainPanel ;

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
		
		mainPanel = new MainPanel();
		panelDisplayer[0] =  createMenu();
		panelDisplayer[1] =  createModSelect();
		panelDisplayer[2] = new PlacementPanel(this);
		panelDisplayer[3] = mainPanel;
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
	
	public void  switchPanel(int a){
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
		JButton classicMod = new ClassicButton();
		JButton previousButton = new JButton("Retour");
		previousButton.addActionListener(new SwitchListenner());
		classicMod.addActionListener(new SwitchListenner());
		classicMod.addActionListener(new ModListener());
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(classicMod, BorderLayout.CENTER);
		panel.add(previousButton, BorderLayout.WEST);
		return panel;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);

	}
}
