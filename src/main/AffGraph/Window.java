/**
 * 
 */
package main.AffGraph;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
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
	private JFrame frame ;

	public static void main(String[] args) {
		new Window();

	}
	
	/**
	 * Construit la fenetre de jeu de taille maximale
	 *
	 */
	
	public Window(){
		JFrame frame= new JFrame();
		Rectangle bounds = getMaxBounds();
		frame.setSize(bounds.width, bounds.height);
		frame.setTitle("Stratego");
		frame.setLocation(0, 0);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.addWindowListener(new WindowAdapter(frame));
		
		panelDisplayer[0] =  createMenu();
		panelDisplayer[1] =  createModSelect();
		panelDisplayer[2] = createGamePanel();
		currentPanel = 0;
	
		frame.add(panelDisplayer[0]);
		
		this.frame = frame;
	
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
		frame.getContentPane().remove(panelDisplayer[currentPanel]);
		currentPanel +=a;
		frame.add(panelDisplayer[currentPanel]);
		frame.validate();
		frame.repaint();
	}
	
	/** crée un conteneur qui contient le menu principal
	 * @return un Jpannel 
	 */
	private JPanel createMenu(){
		JButton buttonPlay = new JButton("Jouer");
		buttonPlay.addActionListener(new SwitchListenner(this));
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
		previousButton.addActionListener(new SwitchListenner(this));
		classicMod.addActionListener(new SwitchListenner(this));
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(classicMod, BorderLayout.CENTER);
		panel.add(previousButton, BorderLayout.WEST);
		return panel;
	}
	
	/**
	 * Crée un conteneur qui affiche le plateau de jeu
	 * @return unJPanel
	 */
	private JPanel createGamePanel(){
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel killedPiecePanel = new JPanel();
		
		new BoxLayout( killedPiecePanel,BoxLayout.Y_AXIS);
		JPanel lostPiecePanel = new JPanel();
		
		new BoxLayout(lostPiecePanel ,BoxLayout.Y_AXIS);
		JPanel gamePanel = new ImagePanel("Logo.jpg");
		
		mainPanel.add(killedPiecePanel, BorderLayout.WEST);
		mainPanel.add(lostPiecePanel, BorderLayout.EAST);
		mainPanel.add(gamePanel, BorderLayout.CENTER);
		
		return mainPanel;
	}


}
