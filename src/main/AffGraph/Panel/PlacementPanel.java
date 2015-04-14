package main.AffGraph.Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.AffGraph.Window;
import main.AffGraph.Window.SwitchListenner;
import main.game.Piece;
import main.game.Position;

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
					currentPiece.setTeam(0);
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
	
	
	SelectPanel selectPanel;
	AlliePiecePanel alliePanel;
	
	public PlacementPanel(Window w){
		super();
		
		JPanel centerPanel = createCenterPanel();
		
		JButton returnButton = new JButton("Retour");
		returnButton.addActionListener(w.new SwitchListenner());
		
		JPanel eastPanel = createEastPanel(w);
		
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
	
	private JPanel createEastPanel(Window w){

		JButton loadButton = new JButton("Charger");
		JButton saveButton = new JButton("Sauver");
		JButton confirmButton = new JButton("Confirmer");
		confirmButton.addActionListener(w.new SwitchListenner());
		
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

}
