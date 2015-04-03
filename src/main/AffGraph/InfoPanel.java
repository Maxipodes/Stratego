/**
 * 
 */
package main.AffGraph;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Maxime
 *
 */
public class InfoPanel extends JPanel {
	
	public InfoPanel(){
		super();	
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		super.paintChildren(g);
	}

}
