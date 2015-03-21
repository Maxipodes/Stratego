/**
 * 
 */
package main.AffGraph;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.MonListenner;

/**
 * @author Maxime
 *
 */
public class Window {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Window();

	}
	/**
	 * Construit la fenetre de jeu
	 * 
	 * @param null
	 * @return void
	 */
	
	public Window(){
		JFrame frame= new JFrame();
		Rectangle bounds = getBounds();
		frame.setSize(bounds.width, bounds.height);
		frame.setTitle("Stratego");
		frame.setLocation(0, 0);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter(frame));
		frame.add(createPanel1());

		
	}
	
	/**
	 * @param null
	 * @return la résolution de l'écran
	 */
	private static Rectangle getBounds(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		return gc.getBounds();
	}
	
	/**
	 * @param null
	 * @return un paneau qui contient le menu principal
	 */
	private static JPanel createPanel1(){
		JButton buttonPlay = new JButton("Jouer");
		buttonPlay.addActionListener(new MonListenner());
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(buttonPlay, BorderLayout.CENTER);
		return panel;
	}
	/*
	private static JPanel createPanel2(){
		
		
	}
	*/

}
