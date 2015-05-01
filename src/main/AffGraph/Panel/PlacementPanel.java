package main.AffGraph.Panel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.AffGraph.Windows.InputWindow;
import main.AffGraph.Windows.Window;
import main.game.Pieces.Piece;
import main.game.BoardGame;
import main.game.Position;
import main.game.Team;

public class PlacementPanel extends JPanel {
	
	public class PlacementListener implements MouseListener{
		
		Piece currentPiece;
		int coordRef ;
		boolean swap;
		Position oldPos;
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			Piece[] tab = BoardGame.getBoardGame().teamBlue.charachter;
			int posX = e.getX();
			int posY = e.getY();
			if(posY<=selectPanel.getHeight()){
				coordRef = pixToCoord(posX);
				if(tab[coordRef].NUMBER -tab[coordRef].currentNumber >0)
					currentPiece = tab[coordRef].construct();
					currentPiece.setTeam(Team.BLUE);
					swap = false;
			}
			else{
				Position coord = pixToCoord(new Position(posX, posY));
				currentPiece = alliePanel.alliePiece[coord.positionX][coord.positionY];
				swap = true;
				oldPos = coord;
			}
			
			
		}

		public void mouseReleased(MouseEvent e) {
			Piece[] tab = BoardGame.getBoardGame().teamBlue.charachter;
			int posX = e.getX();
			int posY = e.getY();
			if(posY>selectPanel.getHeight()){
				Position newPos = pixToCoord(new Position(posX, posY));
				if(swap){
						alliePanel.swap(oldPos, newPos);
						swap=false;
				}
				else{
					if(tab[coordRef].NUMBER!=tab[coordRef].currentNumber){
						System.out.println(newPos);
						if(alliePanel.alliePiece[newPos.positionX][newPos.positionY]==null){
							tab[coordRef].addCurrentNumber();
							alliePanel.addInAllieTab(currentPiece, newPos);
						}
					}
				}
				alliePanel.paintComponent(alliePanel.getGraphics());
				selectPanel.paintComponent(selectPanel.getGraphics());
			}
		}
		
	}
	
	public class ConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(alliePanel.isComplete()){
				MainPanel mp = (MainPanel)window.panelDisplayer[3];
				mp.GAME_PANEL.setPlacement(alliePanel.alliePiece);
				window.switchPanel(1);
			}
			else{
				JOptionPane.showMessageDialog(null,"Remplissez le tableau pour continuer",
						"Information",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}

	}
	
	private class CallInput implements ActionListener{
		
		int mod;
		public CallInput(int mod){
			this.mod=mod;
		}
		
		public void actionPerformed(ActionEvent e) {
			InputWindow iw = new InputWindow(PlacementPanel.this, mod );
		}
		
	}
	
	
	SelectPanel selectPanel;
	AlliePiecePanel alliePanel;
	Window window;
	public int SAVE=0;
	public int LOAD=1;
	
	public PlacementPanel(Window w){
		super();
		window=w;
		
		JPanel centerPanel = createCenterPanel();
		
		JButton returnButton = new JButton("Retour");
		returnButton.addActionListener(w.new SwitchListenner());
		
		JPanel eastPanel = createEastPanel();
		
		setLayout(new BorderLayout());
		super.add(returnButton ,  BorderLayout.WEST);
		super.add(eastPanel,  BorderLayout.EAST);
		super.add(centerPanel, BorderLayout.CENTER);
		
	}
	
	private JPanel createCenterPanel(){
		JPanel centerPanel = new JPanel(new BorderLayout());

		alliePanel = new AlliePiecePanel();
		centerPanel.add(alliePanel, BorderLayout.CENTER);
		
		selectPanel =new SelectPanel();
		centerPanel.add(selectPanel, BorderLayout.NORTH);
		
		centerPanel.addMouseListener(new PlacementListener());
		return centerPanel;
	}
	
	private JPanel createEastPanel(){

		JButton loadButton = new JButton("Charger");
		loadButton.addActionListener(new CallInput(LOAD));
		
		JButton saveButton = new JButton("Sauver");
		saveButton.addActionListener(new CallInput(SAVE));
		
		JButton confirmButton = new JButton("Confirmer");
		confirmButton.addActionListener(new ConfirmListener());
		
		JPanel eastPanel = new JPanel(new GridLayout(3,1));
		eastPanel.add(loadButton);
		eastPanel.add(saveButton);
		eastPanel.add(confirmButton);
		
		return eastPanel;
	}
	
	private int pixToCoord(int x){
		int caseWidth = selectPanel.caseWidth;
		int newX = x/caseWidth;
		return newX;
	
	}
	
	private Position pixToCoord(Position pos){
		int caseWidth = alliePanel.caseWidth;
		int caseHeight = alliePanel.caseHeight;
		
		int newX = pos.positionX/caseWidth;
		int newY = (pos.positionY -selectPanel.getHeight())/caseHeight;
		
		Position newPos = new Position(newX, newY);
		return newPos;
	}
	/**
	 * This method save piece placement in "fileName".tmp
	 * @param fileName
	 */
	private void streamSave(File file){
		int numberPiece = alliePanel.countPiece();
		ObjectOutputStream oos;
		try{
			oos = new ObjectOutputStream(new FileOutputStream(file));
			try{
				oos.writeInt(numberPiece);
				for(Piece[] line : alliePanel.alliePiece){
					for(Piece piece: line){
						if(piece!=null)
							oos.writeObject(piece);
					}
				}
			}
			finally{
				oos.close();
			}
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	private void streamLoad(File file){
		ObjectInputStream ois;
		
		try{
			ois = new ObjectInputStream(new FileInputStream(file));
			
			try{
				int numberObject = ois.readInt();
				Piece currentPiece;
				for(int i=0; i<numberObject; i++){
						currentPiece =(Piece) ois.readObject() ;
						alliePanel.alliePiece[currentPiece.position.positionX][currentPiece.position.positionY]
								=currentPiece;
						BoardGame.getBoardGame().teamBlue.charachter[currentPiece.ref].currentNumber+=1;	
				}
				
			}catch (ClassNotFoundException e){
				e.printStackTrace();
				
			}finally{
				ois.close();
			}
			
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	public void save(String str){
		File file = new File("."+File.separator+"src"+File.separator+
				"save"+File.separator+"PlacementSave"+File.separator+str+".tmp");
		streamSave(file);
	}
	
	public void load(String str){
		File file;
			file =new File("."+File.separator+"src"+File.separator+
					"save"+File.separator+"PlacementSave"+File.separator+str+".tmp");
		if(file.exists()){
			alliePanel.clearTab();
			selectPanel.reInit();
			streamLoad(file);
			paintComponent(getGraphics());
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		super.paintChildren(g);
	}

}
