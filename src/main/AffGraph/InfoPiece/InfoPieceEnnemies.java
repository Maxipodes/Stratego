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
public class InfoPieceEnnemies  extends JLabel implements InfoPiece  {
	
	private Piece piece;
	
	public InfoPieceEnnemies(Piece p){
		super();
		String text = p.NAME+" :  "+(p.NUMBER-p.currentNumber)+"/"+p.NUMBER;
		super.setText(text);
		
		piece=p;
		
			
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String text = piece.NAME+" :  "+piece.currentNumber+"/"+piece.NUMBER;
		super.setText(text);
	}

}
