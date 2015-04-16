package main.AffGraph.Panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import main.game.BoardGame;
import main.game.Piece;



public class SelectPanel extends JPanel {
	
	public Piece[] tab = BoardGame.getBoardGame().teamBlue.charachter;
	int width;
	public int caseWidth;
	
	public SelectPanel(){
		super();
		super.add(Box.createRigidArea(new Dimension(0, 90)));
	}
	
	private int coordToPix(int i){
		int caseWidth = width/12;
		int newPos = i*caseWidth;
		
		return newPos;
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		width = super.getWidth();
		caseWidth = width/12;
		
		for(int i=0; i<tab.length; i++){
			int pos = coordToPix(i);
			g.drawImage(tab[i].getImage(), pos, 0, this);
			String numberRemaining =Integer.toString(tab[i].NUMBER-tab[i].currentNumber);
			g.drawString(numberRemaining, pos+32, 80);
		}
		g.drawLine(0, 90, width, 90);
	}
}
