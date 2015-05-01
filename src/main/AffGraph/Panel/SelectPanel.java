package main.AffGraph.Panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.JPanel;

import main.game.BoardGame;
import main.game.Pieces.Piece;


public class SelectPanel extends JPanel {
	
	int width;
	public int caseWidth;
	
	public SelectPanel(){
		super();
		super.add(Box.createRigidArea(new Dimension(0, 106)));
	}
	
	private int coordToPix(int i){
		int caseWidth = width/12;
		int newPos = i*caseWidth;
		
		return newPos;
		
	}
	
	public void reInit(){
		Piece[] tab = BoardGame.getBoardGame().teamBlue.charachter;
		for(Piece p : tab){
			p.currentNumber=0;
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Piece[] tab = BoardGame.getBoardGame().teamBlue.charachter;
		width = super.getWidth();
		caseWidth = width/12;
		
		for(int i=0; i<tab.length; i++){
			int pos = coordToPix(i);
			g.drawImage(tab[i].getImage(), pos, 0,caseWidth, 70, this);
			String numberRemaining =Integer.toString(tab[i].NUMBER-tab[i].currentNumber);
			g.drawString(numberRemaining, pos+32, 96);
		}
		g.drawLine(0, 106, width, 106);
	}
}
