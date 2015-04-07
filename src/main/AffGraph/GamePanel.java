package main.AffGraph;

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
	Piece[][] boardGame;
	
	public GamePanel(BoardGame boardGame){
		super();
		String image ="."+File.separator+"src"+File.separator+
				"Image"+File.separator+"Logo.jpg";
		this.boardGame = boardGame.BOARD;
		
		for(Piece[] line:this.boardGame){
			for(Piece character:line){
				if(character != null){
					Position newPos = coordToPix(character.position);
					getGraphics().drawImage(character.image.getImage(), newPos.positionX, 
						newPos.positionY, this);
				}
			}
		}
		
		background = new ImageIcon(image);
		update(getGraphics());

	}
	
	private Position coordToPix(Position p){
		int caseHeight = height/10;
		int caseWidth = width/10;
		int newWidth = p.positionX*caseHeight;
		int newHeight = p.positionY*caseWidth;
		
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
		ImageIcon img = boardGame[pos.positionX][pos.positionY].image;
		
		Position newPos = coordToPix(pos);
		Rectangle rect = getRect(newPos);
		repaint(rect);
		
		Position newMovedPos =coordToPix(movedPos);
		getGraphics().drawImage(img.getImage(), newMovedPos.positionX, newMovedPos.positionY, this);
	}
	
	public void refresh(Position pos){
		ImageIcon img = boardGame[pos.positionX][pos.positionY].image;
		
		Position newPos = coordToPix(pos);
		Rectangle rect = getRect(newPos);
		repaint(rect);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage( background.getImage(), 0, 0, null);
		height = super.getHeight();
		width = super.getWidth();
		super.paintChildren(g);
	}

}
