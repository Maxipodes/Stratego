/**
 * 
 */
package main.AffGraph.Windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.AffGraph.ButtonMod.ButtonMod;
import main.AffGraph.ButtonMod.EasyButton;
import main.AffGraph.GameMod.GameMod;
import main.AffGraph.Panel.MainPanel;
import main.AffGraph.Panel.PlacementPanel;
import main.game.GameController;


/**
 * @author Maxime
 *Cette classe permet la creation d un objet Window qui est une fenetre 
 *dont on peut changer le conntenu
 */
public class Window extends JFrame {

	public static void main(String[] args) {
		
		new Window();

	}
	
	/**
	 * Cette classe est un listenner invoquant la methode switchpanel a chaque pression de bouton 
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
	
	public class ContinueListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			File savedFile = new File("."+File.separator+"src"+File.separator
					+"save"+File.separator+"GameSave"+File.separator+"gameSave.tmp");
			if(savedFile.exists()){
				MainPanel mp = (MainPanel)panelDisplayer[3];
				GameController gc ;
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedFile));
					try{
						gc= (GameController) ois.readObject();
						mp.GAME_PANEL.SetGameController(gc);
						Window.this.switchPanel(3);
						savedFile.delete();
						
					}catch (ClassNotFoundException e1) {
						e1.printStackTrace();
						System.exit(1);
						
					}finally{
						ois.close();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					System.exit(1);
				} catch (IOException e1) {
					e1.printStackTrace();
					System.exit(1);
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Vous n avez pas de sauvegarde de jeu",
						"Information",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
	}
	
	public class ModListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			MainPanel mp =mainPanel;
			ButtonMod bm =(ButtonMod) e.getSource();
			GameMod mod = bm.getMod();
			mp.GAME_PANEL.setBoardGame(mod.getBoardGame());
			mp.GAME_PANEL.setAI(mod.getAI());
		}
	}
	
	public JPanel[] panelDisplayer = new JPanel[4];      //Contient les differents panels a afficher
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
	 * @return la resolution maximum de l'ecran
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
	
	/** cree un conteneur qui contient le menu principal
	 * @return un Jpannel 
	 */
	private JPanel createMenu(){
		JButton buttonPlay = new JButton("Jouer");
		buttonPlay.addActionListener(new SwitchListenner());
		JButton buttonContinue =new JButton("Continuer");
		buttonContinue.addActionListener(new ContinueListener());
		
		JPanel panelExt = new JPanel(new BorderLayout());
		panelExt.add(Box.createRigidArea(new Dimension(560, 0)), BorderLayout.WEST);
		panelExt.add(Box.createRigidArea(new Dimension(560, 0)), BorderLayout.EAST);
		panelExt.add(Box.createRigidArea(new Dimension(0, 300)), BorderLayout.NORTH);
		panelExt.add(Box.createRigidArea(new Dimension(0, 300)), BorderLayout.SOUTH);
		
		JPanel panel=new JPanel(new GridLayout(3, 0));
		panel.add(buttonPlay);
		panel.add(Box.createRigidArea(new Dimension(0, 75)));
		panel.add(buttonContinue);
		
		
		panelExt.add(panel, BorderLayout.CENTER);
		
		return panelExt;
	}
	

	/** cree un conteneur qui contient le panel des options de jeu
	 * @return un Jpannel
	 */
	private JPanel createModSelect(){
		JButton classicMod = new EasyButton();
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
