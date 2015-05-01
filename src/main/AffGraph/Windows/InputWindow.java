package main.AffGraph.Windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.AffGraph.Panel.PlacementPanel;

public class InputWindow extends JFrame{
	
	private class IsReady implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(mod==pp.SAVE)
				pp.save(getText());
			else
				pp.load(getText());
			InputWindow.this.dispose();
		}
		
	}
	
	private JTextField textField;
	private PlacementPanel pp;
	private int mod ;
	/**
	 * create a window with a JTextField , a JLabel and a JButton 
	 */
	public InputWindow(PlacementPanel pp, int mod){
		super();
		this.pp = pp;
		this.mod=mod;
		
		super.setTitle("Fenetre de selection");
		super.setSize(new Dimension(300, 150));
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		
		JPanel panel = new JPanel(new GridLayout(3, 0));
		panel.add(new JLabel("Saississez le nom du fichier"));
		textField = new JTextField(10);
		panel.add(textField);
		
		JButton button = new JButton("OK");
		button.addActionListener(new IsReady());
		
		JPanel paneInt=new JPanel(new BorderLayout());
		paneInt.add(Box.createRigidArea(new Dimension(100, 0)), BorderLayout.WEST);
		paneInt.add(Box.createRigidArea(new Dimension(100, 0)), BorderLayout.EAST);
		paneInt.add(button, BorderLayout.CENTER);
				
		panel.add(paneInt);
	
		super.add(panel);
		paintComponents(this.getGraphics());
		
	}
	
	/**
	 * 
	 * @return the text contained in the JTextField
	 */
	public String getText(){
		return textField.getText();
	}
	
	public void paintComponents(Graphics g){
		super.paintComponents(g);
	}
}
