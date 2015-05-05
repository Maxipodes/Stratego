/**
 * 
 */
package main.AffGraph.InfoPiece;

import java.awt.Graphics;

import javax.swing.JLabel;

import main.game.Team;
import main.game.Pieces.Piece;

/**
 * @author Maxime
 *
 */
public class InfoPieceEnnemies  extends JLabel{
	
	private Piece piece;
	private Team team;
	private int ref;
	
	public InfoPieceEnnemies(Piece p, Team t){
		super();
		team =t;
		ref =p.ref;
		String text = p.NAME+" :  "+(p.NUMBER-team.charachter[p.ref].currentNumber)+"/"+p.NUMBER;
		super.setText(text);
		
		piece=p;
		
			
	}

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		String text = piece.NAME+" :  "+(piece.NUMBER-team.charachter[ref].currentNumber)+"/"+piece.NUMBER;
		super.setText(text);
	}

}
