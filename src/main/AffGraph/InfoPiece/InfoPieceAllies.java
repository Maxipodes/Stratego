/**
 * 
 */
package main.AffGraph.InfoPiece;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

import main.game.Piece;


/**
 * @author Maxime
 *
 */
public class InfoPieceAllies extends JLabel {

	
	public static void main(String[] args) {

	}
	private Piece piece;
	
	public InfoPieceAllies(Piece p){
		super();
		String text = p.NAME+" :  "+p.currentNumber+"/"+p.NUMBER;
		super.setText(text);
		piece=p;
			
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String text = piece.NAME+" :  "+piece.currentNumber+"/"+piece.NUMBER;
		super.setText(text);
	}
	

}
