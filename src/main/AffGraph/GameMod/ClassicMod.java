package main.AffGraph.GameMod;

import main.game.BoardGame;
import main.game.Pieces.Piece;

public class ClassicMod implements GameMod{
	
	public Piece[][] getBoardGame(){
		BoardGame bg = BoardGame.getBoardGame();
		bg.randFillInBoardGame();
		return bg.BOARD;
	}
}
