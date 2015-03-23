/**
 * 
 */
package main.AffGraph;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Maxime
 *
 */
public class ImagePanel extends JPanel {
	
	String nameImage;

	/**
	 * @param args
	 */

	public static void main(String[] args){
		
		JFrame frame= new JFrame();
		frame.setSize(800, 500);
		frame.setTitle("Stratego");
		frame.setLocation(0, 0);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel image = new ImagePanel("Logo.jpg");
		frame.setContentPane(image);

	}
	
	public ImagePanel(String nomImage){
		super();
		this.nameImage = nomImage;
	}
	
	public void paintComponent(Graphics g) {

		 try {
			
			FileInputStream input = new FileInputStream("."+File.separator+"src"+File.separator+
					"Image"+File.separator+nameImage);
			Image img = ImageIO.read(input);
			g.drawImage(img, 0, 0, this);
		 } 
		 catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		 }
		 
		
	}
}
		


