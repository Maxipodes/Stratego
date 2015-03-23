package main;
import javax.swing.JButton;
import javax.swing.JFrame;




import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;


public class InterGraphTest2 {
	public static void main (String[] args){
		/*
		JFrame frame = new JFrame();
		frame.setTitle("Coucou Biatch !");
		frame.setSize(400, 300);
		frame.setLocation(440, 234);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		*/
		JFrame frame=createWindow(400, 300 , "LAMAAAAAAAAAAAAAAAAAA!!!!");
		JButton button = new JButton("Repair");
		MyPanel panel =new MyPanel();
		frame.add(panel);
		/*
		button.addActionListener(new MonListenner(){
			public void actionPerformed(ActionEvent e){
				button.setText("Pentakil !!!");
			}
			
		});
		*/
		panel.add(button);
		
	}

	public static JFrame createWindow(int width , int height, String name){
		JFrame newFrame = new JFrame();
		newFrame.setSize(width, height);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		Rectangle bounds = gc.getBounds();
		
		newFrame.setLocation((bounds.width/2-width/2),(bounds.height/2-height/2));
		newFrame.setTitle(name);
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setVisible(true);
		
		return newFrame;
	}
	
}
