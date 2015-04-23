package main.AffGraph.Panel;

import java.awt.Graphics;

import javax.swing.JPanel;

import main.game.Pieces.Piece;
import main.game.Position;

public class AlliePiecePanel extends JPanel{
	
	public Piece[][] alliePiece;
	private int width;
	private int height;
	public int caseWidth;
	public int caseHeight;
	
	public AlliePiecePanel(){
		super();
		alliePiece = new Piece[10][4];
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		height = super.getHeight();
		width = super.getWidth();
		caseHeight = height/4;
		caseWidth = width/10;
		
		for(Piece[] line: alliePiece){
			for(Piece p : line){
				if(p!=null){
					Position newPos = coordToPix(p.position);
					g.drawImage(p.getImage(), newPos.positionX
							,newPos.positionY,caseWidth, caseHeight, this);
				}
			}
		}
	}
	
	private Position coordToPix(Position p){
		
		int newWidth = p.positionX*caseWidth;
		int newHeight = p.positionY*caseHeight;
		
		return new Position(newWidth, newHeight);
		
	}
	
	public Piece[][] getAllieTab(){
		return alliePiece;
	}
	
	public void addInAllieTab(Piece p, Position pos){
		alliePiece[pos.positionX][pos.positionY]=p;
		p.setPosition(pos.positionX, pos.positionY);
	}
	
	public void swap(Position pos1, Position pos2){
		Piece oldPiece = alliePiece[pos2.positionX][pos2.positionY];
		Piece newPiece = alliePiece[pos1.positionX][pos1.positionY];
		
		alliePiece[pos2.positionX][pos2.positionY] = newPiece;
		if(newPiece!=null)
			newPiece.setPosition(pos2.positionX, pos2.positionY);
		
		alliePiece[pos1.positionX][pos1.positionY] = oldPiece;
		if(oldPiece!=null)
			oldPiece.setPosition(pos1.positionX, pos1.positionY);
	}
	
	public boolean isComplete(){
		
		for(Piece[] line:alliePiece){
			for(Piece p:line){
				if(p==null)
					return false;
			}
		}
		return true;
	}
}
