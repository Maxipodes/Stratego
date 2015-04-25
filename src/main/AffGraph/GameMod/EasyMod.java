package main.AffGraph.GameMod;

import main.game.AI.AI;
import main.game.BoardGame;
import main.game.AI.RandAI;
import main.game.Pieces.Piece;

public class EasyMod implements GameMod{
	
	public Piece[][] getBoardGame(){
		BoardGame bg = BoardGame.getBoardGame();
		bg.randFillInBoardGame();
		return bg.BOARD;
	}
	
	public AI getAI(){
		return RandAI.getAI();
	}
}
