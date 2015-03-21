package main;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
	
public class ImagePane extends JPanel{

	public static void main(String[] args) throws IOException {
		JFrame frame= new JFrame();
		frame.setTitle("TestImage");
		frame.setSize(500, 300);
		ImagePane pane = new ImagePane(File.separatorChar+"Image"+File.separatorChar+"Logo.png");
		frame.add(pane);
		frame.setVisible(true);
	}
	
	
	 
	     
	 private static final long   serialVersionUID    = 1L;
	 protected Image image;    
	     
	 public ImagePane(String image) throws IOException{
	     this.image = ImageIO.read(new URL(image));
	 }  
	         
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 g.drawImage(image, 0, 0, null); 
	 }


}
