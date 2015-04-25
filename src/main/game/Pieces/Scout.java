package main.game.Pieces;

import main.game.BoardGame;

public class Scout extends Piece 
{
	public Scout() 
	{	
		NAME = "Scout";
		RANK = 2;
		NUMBER = 8;
		WEAKNESS = 0;	
		MOVE = BoardGame.LENGTHX;		
		currentNumber = 0;
		SEEN = false;
		hasMove = false;
		ref =1;
	}

	public Scout construct()
	{
		return new Scout();
	}	
	
	
}
