package main.AffGraph.Panel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.game.BoardGame;
import main.game.Piece;
import main.game.Position;

public class GamePanel extends JPanel{
	
	int height;
	int width;
	ImageIcon background;
	BoardGame boardGame;
	
	public GamePanel(){
		super();
		
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Logo.jpg";
		
		background = new ImageIcon(image);
		boardGame =BoardGame.getBoardGame();
		boardGame.randFillInBoardGame();

	}
	
	public void setBoardGame(Piece[][] tab){
		boardGame.setBoardGame(tab);
	}
	
	public void setPlacement(Piece[][] pieceTab){
		for(int y=0; y < pieceTab[0].length; y++){
			for(int x=0; x<pieceTab.length; x++){
				boardGame.BOARD[x][y+6] = pieceTab[x][y]; 
				boardGame.BOARD[x][y+6].setPosition(x, y+6);
			}
		}
	}
	
	private Position coordToPix(Position p){
		int caseHeight = height/10;
		int caseWidth = width/10;
		int newWidth = p.positionX*caseWidth;
		int newHeight = p.positionY*caseHeight;
		
		return new Position(newWidth, newHeight);
		
	}
	
	private Rectangle getRect(Position p){
		int caseHeight = height/10;
		int caseWidth = width/10;
		int lowerRigthCornerX = p.positionX+caseWidth;
		int lowerRigthCornerY = p.positionY+caseHeight;
		
		return new Rectangle(p.positionX, p.positionY, lowerRigthCornerX , lowerRigthCornerY);
	}
	
	public void refresh(Position pos, Position movedPos){
		Piece p = boardGame.BOARD[pos.positionX][pos.positionY];
		
		Position newPos = coordToPix(pos);
		Rectangle rect = getRect(newPos);
		repaint(rect);
		
		Position newMovedPos =coordToPix(movedPos);
		getGraphics().drawImage(p.getImage(), newMovedPos.positionX, newMovedPos.positionY, this);
	}
	
	public void refresh(Position pos){
		Position newPos = coordToPix(pos);
		Rectangle rect = getRect(newPos);
		repaint(rect);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		height = super.getHeight();
		width = super.getWidth();
		
		g.drawImage( background.getImage(), 0, 0, null);
		
		for(Piece[] line:this.boardGame.BOARD){
			for(Piece character:line){
				if(character != null){
					Position newPos = coordToPix(character.position);
					g.drawImage(character.getImage(), newPos.positionX, 
							newPos.positionY, null);
				}
			}
		}
			
	}

}
