package main.AffGraph.Panel;

import java.awt.BorderLayout;
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
			int posX = e.getX();
			int posY = e.getY();
			if(posY<=selectPanel.getHeight()){
				coordRef = pixToCoord(posX);
				if(selectPanel.tab[coordRef].NUMBER -selectPanel.tab[coordRef].currentNumber >0)
					currentPiece = selectPanel.tab[coordRef].construct();
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
			int posX = e.getX();
			int posY = e.getY();
			if(posY>selectPanel.getHeight()){
				Position newPos = pixToCoord(new Position(posX, posY));
				if(swap){
						alliePanel.swap(oldPos, newPos);
						swap=false;
				}
				else{
					if(selectPanel.tab[coordRef].NUMBER!=
							selectPanel.tab[coordRef].currentNumber){
						System.out.println(newPos);
						if(alliePanel.alliePiece[newPos.positionX][newPos.positionY]==null){
							selectPanel.tab[coordRef].addCurrentNumber();
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
				mp.GAME_PANEL.setPlacement(alliePanel.getAllieTab());
				window.switchPanel(1);
			}
			else{
				JOptionPane.showMessageDialog(null,"Remplissez le tableau pour continuer",
						"Information",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}

	}
	
	
	public class LoadListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			InputWindow iw = new InputWindow();
			File file;
			do{
				file =new File("."+File.separator+"src"+File.separator+
						"save"+File.separator+"PlacementSave"+File.separator+iw.getText()+".tmp");
			
			}while(!(file.exists()));
			load(file);
			selectPanel.reInit();
			paintComponent(getGraphics());
		}
		
	}
	
	public class SaveListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			InputWindow iw = new InputWindow();
			while(!(iw.isReady)){
				// do nothing until iw.isReady is true 
				//ie until user click on "Ok" button
			}
			File file = new File("."+File.separator+"src"+File.separator+
					"save"+File.separator+"PlacementSave"+File.separator+iw.getText()+".tmp");
			save(file);
			selectPanel.reInit();
			paintComponent(getGraphics());
		}
		
	}
	
	
	
	SelectPanel selectPanel;
	AlliePiecePanel alliePanel;
	Window window;
	
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
		JButton saveButton = new JButton("Sauver");
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
	private void save(File file){
		ObjectOutputStream oos;
		try{
			oos = new ObjectOutputStream(new FileOutputStream(file));
			try{
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
	
	private void load(File file){
		ObjectInputStream ois;
		
		try{
			ois = new ObjectInputStream(new FileInputStream(file));
			
			try{
				Piece currentPiece =(Piece) ois.readObject();
				if(currentPiece!=null){
					do{
						alliePanel.alliePiece[currentPiece.position.positionX][currentPiece.position.positionY]
								=currentPiece;
						currentPiece=(Piece)ois.readObject();
						BoardGame.getBoardGame().teamBlue.charachter[currentPiece.ref].currentNumber-=1;
					}while(currentPiece!=null);
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
	
	

}
