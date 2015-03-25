/**
 * 
 */
package main.AffGraph;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Maxime
 *
 */
public class Window extends JFrame {

	
	private JPanel[] panelDisplayer = new JPanel[2];      //Contient les différents panels a afficher
	private int currentPanel ;
	private JFrame frame ;

	/**
	 * @param args
	 */
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
		
		panelDisplayer[0] =  PanelCreator.createMenu(this);
		panelDisplayer[1] =  PanelCreator.createModSelect(this);
		currentPanel = 0;
	
		frame.add(panelDisplayer[0]);
		
		this.frame = frame;
	
	}
	
	public JFrame getFrame(){
		return frame;
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
	 * Methode qui permet de changer le contenu de la 
	 * @param a -1 pour retourner au panel precedent , 1 pour passer au panel suivant
	 */
	
	public void  switchPanel(int a){
		frame.getContentPane().remove(panelDisplayer[currentPanel]);
		currentPanel +=a;
		frame.add(panelDisplayer[currentPanel]);
		frame.validate();
		frame.repaint();
	}
	
	

}
