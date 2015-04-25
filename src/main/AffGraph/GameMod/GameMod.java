package main.AffGraph.GameMod;

import main.game.AI.AI;
import main.game.Pieces.Piece;

public interface GameMod {
	
	public Piece[][] getBoardGame();
	
	public AI getAI();
}
