import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MyPanel extends JPanel{

	public MyPanel() {
		
	}

	public static void main(String[] args) {
	

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString("Please, push repair :-p !", 10, 20);
	}
	
	
}
