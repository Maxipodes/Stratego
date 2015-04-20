/**
 * 
 */
package main.AffGraph.InfoPiece;


import java.awt.Graphics;

import javax.swing.JLabel;

import main.game.Pieces.Piece;


/**
 * @author Maxime
 *
 */
public class InfoPieceAllies extends JLabel implements InfoPiece {

	
	public static void main(String[] args) {

	}
	private Piece piece;
	
	public InfoPieceAllies(Piece p){
		super();
		String text = p.NAME+" :  "+(p.NUMBER-p.currentNumber)+"/"+p.NUMBER;
		super.setText(text);
		piece=p;
			
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String text = piece.NAME+" :  "+(piece.NUMBER-piece.currentNumber)+"/"+piece.NUMBER;
		super.setText(text);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	

}
